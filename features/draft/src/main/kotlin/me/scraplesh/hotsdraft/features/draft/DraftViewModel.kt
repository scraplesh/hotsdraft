package me.scraplesh.hotsdraft.features.draft

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.Hero
import me.scraplesh.domain.Role
import me.scraplesh.domain.Universe
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.draft.DraftAction
import me.scraplesh.domain.draft.Team

interface Repository

interface DraftRepository : Repository {
  fun getCurrentAction(): Flow<DraftAction>
}

interface UseCase

class GetCurrentActionUseCase(private val repo: DraftRepository) : UseCase {
  operator fun invoke(): Flow<DraftAction> = repo.getCurrentAction()
}

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftViewModel(
  initialState: State
) :
  ViewModel(),
  FlowCollector<DraftViewModel.Wish>,
  Flow<DraftViewModel.State> {

  private val states = ConflatedBroadcastChannel(initialState)
  private val wishes = ConflatedBroadcastChannel<Wish>()
  private val effects = ConflatedBroadcastChannel<Effect>()

  init {
    viewModelScope.launch {
      wishes.asFlow()
        .map { wish -> act(wish, states.value) }
        .map { effect -> reduce(states.value, effect) }
        .collect { state -> states.send(state) }
    }
  }

  sealed class Wish {
    class SelectHero(val hero: Hero) : Wish()
  }

  data class State(
    val draft: Draft,
    val selectedUniverse: Universe? = null,
    val selectedRole: Role? = null,
    val heroes: List<Hero> = Hero.values().asList(),
    val yourPick1: Hero? = null,
    val yourPick2: Hero? = null,
    val yourPick3: Hero? = null,
    val yourPick4: Hero? = null,
    val yourPick5: Hero? = null,
    val yourBan1: Hero? = null,
    val yourBan2: Hero? = null,
    val yourBan3: Hero? = null,
    val enemyPick1: Hero? = null,
    val enemyPick2: Hero? = null,
    val enemyPick3: Hero? = null,
    val enemyPick4: Hero? = null,
    val enemyPick5: Hero? = null,
    val enemyBan1: Hero? = null,
    val enemyBan2: Hero? = null,
    val enemyBan3: Hero? = null
  ) {
    val battleground get() = draft.battleground
  }

  class Effect

  override suspend fun collect(collector: FlowCollector<State>) {
    states.asFlow()
      .collect(collector)
  }

  override suspend fun emit(value: Wish) {
    wishes.send(value)
  }

  private fun act(wish: Wish, state: State): Effect {
    TODO()
  }

  private fun reduce(state: State, effect: Effect): State {
    TODO()
  }
}
