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
    object CheckAllUniverses : Wish()
    object CheckDiablo : Wish()
    object CheckNexus : Wish()
    object CheckOverwatch : Wish()
    object CheckStarcraft : Wish()
    object CheckWarcraft : Wish()
    object CheckAllRoles : Wish()
    object CheckBruiser : Wish()
    object CheckHealer : Wish()
    object CheckMeleeAssassin : Wish()
    object CheckRangedAssassin : Wish()
    object CheckSupport : Wish()
    object CheckTank : Wish()
  }

  data class State(
    val battleground: Battleground,
    val actions: List<Pair<Team, DraftAction>>,
    val draftedHeroes: List<Triple<Team, DraftAction, Hero>> = emptyList(),
    val selectedUniverse: Universe? = null,
    val selectedRole: Role? = null,
    val proposedHeroes: List<Hero> = Hero.values().asList(),
    val filteredHeroes: List<Hero> = proposedHeroes
  ) {
    val currentAction get() = actions.firstOrNull()
    val nextAction get() = actions.getOrNull(1)

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
    class AllUniversesChecked(val filteredHeroes: List<Hero>) : Effect()
    class DiabloChecked(val filteredHeroes: List<Hero>) : Effect()
    class NexusChecked(val filteredHeroes: List<Hero>) : Effect()
    class OverwatchChecked(val filteredHeroes: List<Hero>) : Effect()
    class StarcraftChecked(val filteredHeroes: List<Hero>) : Effect()
    class WarcraftChecked(val filteredHeroes: List<Hero>) : Effect()
    class AllRolesChecked(val filteredHeroes: List<Hero>) : Effect()
    class BruiserChecked(val filteredHeroes: List<Hero>) : Effect()
    class HealerChecked(val filteredHeroes: List<Hero>) : Effect()
    class MeleeAssassinChecked(val filteredHeroes: List<Hero>) : Effect()
    class RangedAssassinChecked(val filteredHeroes: List<Hero>) : Effect()
    class SupportChecked(val filteredHeroes: List<Hero>) : Effect()
    class TankChecked(val filteredHeroes: List<Hero>) : Effect()
    class HeroSelected(
      val draftedHeroes: List<Triple<Team, DraftAction, Hero>>,
      val proposedHeroes: List<Hero>,
      val filteredHeroes: List<Hero>,
      val actions: List<Pair<Team, DraftAction>>
    ) : Effect()
  }

  override suspend fun collect(collector: FlowCollector<State>) {
    states.asFlow()
      .collect(collector)
  }

  override suspend fun emit(value: Wish) {
    wishes.send(value)
  }

  private fun act(wish: Wish, state: State): Flow<Effect> {
    fun selectHero(hero: Hero, currentAction: Pair<Team, DraftAction>?): Flow<Effect> =
      currentAction?.let { (team, action) ->
        flowOf(
          Effect.HeroSelected(
            draftedHeroes = state.draftedHeroes + Triple(team, action, hero),
            proposedHeroes = state.proposedHeroes.filter { it != hero },
            filteredHeroes = state.filteredHeroes.filter { it != hero },
            actions = state.actions.drop(1)
          )
        )
      }
        ?: emptyFlow()

    fun checkAllUniverses(
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.AllUniversesChecked(
        proposedHeroes.filter { hero ->
          selectedRole?.let { hero.role == selectedRole } ?: true
        }
      )
    )
    fun checkDiablo(
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.DiabloChecked(proposedHeroes.filter { hero ->
        hero.universe == Universe.Diablo &&
            selectedRole?.let { hero.role == selectedRole } ?: true
      })
    )
    fun checkNexus(
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.NexusChecked(proposedHeroes.filter { hero ->
        hero.universe == Universe.Nexus &&
            selectedRole?.let { hero.role == selectedRole } ?: true
      })
    )
    fun checkOverwatch(
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.OverwatchChecked(proposedHeroes.filter { hero ->
        hero.universe == Universe.Overwatch &&
            selectedRole?.let { hero.role == selectedRole } ?: true
      })
    )
    fun checkStarcraft(
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.StarcraftChecked(proposedHeroes.filter { hero ->
        hero.universe == Universe.Starcraft &&
            selectedRole?.let { hero.role == selectedRole } ?: true
      })
    )
    fun checkWarcraft(
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.WarcraftChecked(proposedHeroes.filter { hero ->
        hero.universe == Universe.Warcraft &&
            selectedRole?.let { hero.role == selectedRole } ?: true
      })
    )
    fun checkAllRoles(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.AllRolesChecked(proposedHeroes.filter { hero ->
        selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )
    fun checkBruiser(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.BruiserChecked(proposedHeroes.filter { hero ->
        hero.role == Role.Bruiser &&
            selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )
    fun checkHealer(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.HealerChecked(proposedHeroes.filter { hero ->
        hero.role == Role.Healer &&
            selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )
    fun checkMeleeAssassin(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.MeleeAssassinChecked(proposedHeroes.filter { hero ->
        hero.role == Role.MeleeAssassin &&
            selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )
    fun checkRangedAssassin(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.RangedAssassinChecked(proposedHeroes.filter { hero ->
        hero.role == Role.RangedAssassin &&
            selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )
    fun checkSupport(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.SupportChecked(proposedHeroes.filter { hero ->
        hero.role == Role.Support &&
            selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )
    fun checkTank(
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.TankChecked(proposedHeroes.filter { hero ->
        hero.role == Role.Tank &&
            selectedUniverse?.let { hero.universe == selectedUniverse } ?: true
      })
    )

    return when (wish) {
      is Wish.SelectHero -> selectHero(wish.hero, state.currentAction)
      Wish.CheckAllUniverses -> checkAllUniverses(state.proposedHeroes, state.selectedRole)
      Wish.CheckDiablo -> checkDiablo(state.proposedHeroes, state.selectedRole)
      Wish.CheckNexus -> checkNexus(state.proposedHeroes, state.selectedRole)
      Wish.CheckOverwatch -> checkOverwatch(state.proposedHeroes, state.selectedRole)
      Wish.CheckStarcraft -> checkStarcraft(state.proposedHeroes, state.selectedRole)
      Wish.CheckWarcraft -> checkWarcraft(state.proposedHeroes, state.selectedRole)
      Wish.CheckAllRoles -> checkAllRoles(state.proposedHeroes, state.selectedUniverse)
      Wish.CheckBruiser -> checkBruiser(state.proposedHeroes, state.selectedUniverse)
      Wish.CheckHealer -> checkHealer(state.proposedHeroes, state.selectedUniverse)
      Wish.CheckMeleeAssassin -> checkMeleeAssassin(state.proposedHeroes, state.selectedUniverse)
      Wish.CheckRangedAssassin -> checkRangedAssassin(state.proposedHeroes, state.selectedUniverse)
      Wish.CheckSupport -> checkSupport(state.proposedHeroes, state.selectedUniverse)
      Wish.CheckTank -> checkTank(state.proposedHeroes, state.selectedUniverse)
    }
  }

  private fun reduce(state: State, effect: Effect): State = when (effect) {
    is Effect.HeroSelected -> state.copy(
      draftedHeroes = effect.draftedHeroes,
      proposedHeroes = effect.proposedHeroes,
      filteredHeroes = effect.filteredHeroes,
      actions = effect.actions
    )
    is Effect.AllUniversesChecked -> state.copy(
      selectedUniverse = null,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.DiabloChecked -> state.copy(
      selectedUniverse = Universe.Diablo,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.NexusChecked -> state.copy(
      selectedUniverse = Universe.Nexus,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.OverwatchChecked -> state.copy(
      selectedUniverse = Universe.Overwatch,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.StarcraftChecked -> state.copy(
      selectedUniverse = Universe.Starcraft,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.WarcraftChecked -> state.copy(
      selectedUniverse = Universe.Warcraft,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.AllRolesChecked -> state.copy(
      selectedRole = null,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.BruiserChecked -> state.copy(
      selectedRole = Role.Bruiser,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.HealerChecked -> state.copy(
      selectedRole = Role.Healer,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.MeleeAssassinChecked -> state.copy(
      selectedRole = Role.MeleeAssassin,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.RangedAssassinChecked -> state.copy(
      selectedRole = Role.RangedAssassin,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.SupportChecked -> state.copy(
      selectedRole = Role.Support,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.TankChecked -> state.copy(
      selectedRole = Role.Tank,
      filteredHeroes = effect.filteredHeroes
    )
  }
}
