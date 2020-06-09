package me.scraplesh.mviflow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
abstract class MviFeature<Wish, Action, Effect, News, State>(
  coroutineScope: CoroutineScope,
  initialState: State,
  wishToAction: WishToAction<Wish, Action>,
  bootstrapper: Bootstrapper<Action>? = null,
  actor: Actor<Action, State, Effect>,
  reducer: Reducer<State, Effect>,
  newsPublisher: NewsPublisher<Action, Effect, State, News>? = null,
  postProcessor: PostProcessor<Action, Effect, State>? = null
) : Feature<Wish, State, News> {

  private val wishesChannel = ConflatedBroadcastChannel<Wish>()
  private val actionsChannel = ConflatedBroadcastChannel<Action>()
  private val statesChannel = ConflatedBroadcastChannel(initialState)
  private val newsChannel = ConflatedBroadcastChannel<News>()

  override val state: State get() = statesChannel.value
  override val news: Flow<News> get() = newsChannel.asFlow()

  init {
    flowOf(
      bootstrapper?.invoke() ?: emptyFlow(),
      wishesChannel.asFlow()
        .map { wish -> wishToAction(wish) },
      actionsChannel.asFlow()
    )
      .flattenMerge()
      .flatMapConcat { action ->
        actor(
          action,
          statesChannel.value
        ).map { effect -> action to effect }
      }
      .map { (wish, effect) -> Triple(wish, effect, reducer(statesChannel.value, effect)) }
      .onEach { (action, effect, state) ->
        statesChannel.send(state)
        newsPublisher?.invoke(action, effect, state)?.let { newsChannel.send(it) }
        postProcessor?.invoke(action, effect, state)?.let { actionsChannel.send(it) }
      }
      .launchIn(coroutineScope)
  }

  override suspend fun collect(collector: FlowCollector<State>) {
    statesChannel.asFlow()
      .collect(collector)
  }

  override suspend fun emit(value: Wish) {
    wishesChannel.send(value)
  }
}
