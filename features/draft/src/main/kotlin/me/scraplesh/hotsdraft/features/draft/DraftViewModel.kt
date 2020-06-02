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
import me.scraplesh.domain.draft.BanPosition
import me.scraplesh.domain.draft.DraftAction
import me.scraplesh.domain.draft.Player
import me.scraplesh.domain.draft.Team

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftViewModel(initialState: State) :
  ViewModel(),
  FlowCollector<DraftViewModel.Wish>,
  Flow<DraftViewModel.State> {

  private val states = ConflatedBroadcastChannel(initialState)
  private val wishes = ConflatedBroadcastChannel<Wish>()

  init {
    viewModelScope.launch {
      wishes.asFlow()
        .flatMapConcat { wish -> act(wish, states.value) }
        .map { effect -> reduce(states.value, effect) }
        .collect { state -> states.send(state) }
    }
  }

  sealed class Wish {
    class SelectHero(val hero: Hero) : Wish()
  }

  data class State(
    val battleground: Battleground,
    val actions: List<Pair<Team, DraftAction>>,
    val draftedHeroes: List<Triple<Team, DraftAction, Hero>> = emptyList(),
    val selectedUniverse: Universe? = null,
    val selectedRole: Role? = null,
    val heroes: List<Hero> = Hero.values().asList()
  ) {
    val currentAction get() = actions.firstOrNull()

    val yourPick1: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Pick && action.player == Player.First
      }?.third
    val yourPick2: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Pick && action.player == Player.Second
      }?.third
    val yourPick3: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Pick && action.player == Player.Third
      }?.third
    val yourPick4: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Pick && action.player == Player.Forth
      }?.third
    val yourPick5: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Pick && action.player == Player.Fifth
      }?.third
    val yourBan1: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Ban && action.banPosition == BanPosition.First
      }?.third
    val yourBan2: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Ban && action.banPosition == BanPosition.Second
      }?.third
    val yourBan3: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Your && action is DraftAction.Ban && action.banPosition == BanPosition.Third
      }?.third
    val enemyPick1: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Pick && action.player == Player.First
      }?.third
    val enemyPick2: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Second
      }?.third
    val enemyPick3: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Third
      }?.third
    val enemyPick4: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Forth
      }?.third
    val enemyPick5: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Fifth
      }?.third
    val enemyBan1: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Ban && action.banPosition == BanPosition.First
      }?.third
    val enemyBan2: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Ban && action.banPosition == BanPosition.Second
      }?.third
    val enemyBan3: Hero?
      get() = draftedHeroes.firstOrNull { (team, action, _) ->
        team == Team.Enemy && action is DraftAction.Ban && action.banPosition == BanPosition.Third
      }?.third
  }

  sealed class Effect {
    object NoEffect : Effect()
    class HeroSelected(val team: Team, val action: DraftAction, val hero: Hero) : Effect()
  }

  override suspend fun collect(collector: FlowCollector<State>) {
    states.asFlow()
      .collect(collector)
  }

  override suspend fun emit(value: Wish) {
    wishes.send(value)
  }

  private fun act(wish: Wish, state: State): Flow<Effect> {
    fun selectHero(hero: Hero, currentAction: Pair<Team, DraftAction>?): Flow<Effect> {
      return flowOf(
        currentAction?.let { (team, action) ->
          Effect.HeroSelected(team, action, hero)
        }
          ?: Effect.NoEffect
      )
    }

    return when (wish) {
      is Wish.SelectHero -> selectHero(wish.hero, state.currentAction)
    }
  }

  private fun reduce(state: State, effect: Effect): State = when (effect) {
    is Effect.HeroSelected -> state.copy(
      draftedHeroes = state.draftedHeroes + Triple(effect.team, effect.action, effect.hero),
      actions = state.actions.drop(1)
    )
    Effect.NoEffect -> state
  }
}
