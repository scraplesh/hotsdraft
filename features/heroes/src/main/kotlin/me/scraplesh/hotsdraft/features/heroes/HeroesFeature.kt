package me.scraplesh.hotsdraft.features.heroes

import kotlinx.coroutines.flow.*
import me.scraplesh.hotsdraft.domain.entity.HeroEntity
import me.scraplesh.hotsdraft.domain.usecases.GetHeroesUseCase
import me.scraplesh.mviflow.*

class HeroesFeature(initialState: State, getHeroesUseCase: GetHeroesUseCase) :
  MviFeature<
      HeroesFeature.Wish,
      HeroesFeature.Action,
      HeroesFeature.Effect,
      Nothing,
      HeroesFeature.State
      >(
    initialState = initialState,
    wishToAction = HeroesWishToAction(),
    bootstrapper = HeroesBootstrapper(),
    actor = HeroesActor(getHeroesUseCase = getHeroesUseCase),
    reducer = HeroesReducer(),
    postProcessor = HeroesPostProcessor()
  ) {

  class Wish

  enum class Action { GetHeroes }

  data class State(
    val heroes: List<HeroEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null
  )

  sealed class Effect {
    class HeroesGot(val heroes: List<HeroEntity>) : Effect()
    object StartedLoading : Effect()
    object ErrorLoadingHeroesOccurred : Effect()
  }

  class HeroesWishToAction : WishToAction<Wish, Action> {
    override fun invoke(wish: Wish): Action = Action.GetHeroes
  }

  class HeroesBootstrapper : Bootstrapper<Action> {
    override fun invoke(): Flow<Action> = flowOf(Action.GetHeroes)
  }

  class HeroesActor(private val getHeroesUseCase: GetHeroesUseCase) : Actor<Action, State, Effect> {
    override suspend fun invoke(action: Action, state: State): Flow<Effect> = when (action) {
      Action.GetHeroes -> getHeroes()
    }

    private suspend fun getHeroes(): Flow<Effect> =
      getHeroesUseCase().map<List<HeroEntity>, Effect> { heroes -> Effect.HeroesGot(heroes) }
        .onStart { emit(Effect.StartedLoading) }
        .catch { emit(Effect.ErrorLoadingHeroesOccurred) }
  }

  class HeroesReducer : Reducer<State, Effect> {
    override fun invoke(state: State, effect: Effect): State = when (effect) {
      is Effect.HeroesGot -> state.copy(heroes = effect.heroes, isLoading = false)
      Effect.StartedLoading -> state.copy(isLoading = true, error = null)
      Effect.ErrorLoadingHeroesOccurred -> state.copy(error = Throwable(), isLoading = false)
    }
  }

  class HeroesPostProcessor :
    PostProcessor<Action, Effect, State> {
    override fun invoke(action: Action, effect: Effect, state: State): Action? {
      return null
    }
  }
}

