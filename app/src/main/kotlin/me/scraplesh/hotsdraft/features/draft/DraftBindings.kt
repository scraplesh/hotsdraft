package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.draft.BanPosition
import me.scraplesh.domain.draft.DraftAction
import me.scraplesh.domain.draft.Player
import me.scraplesh.domain.draft.Team
import me.scraplesh.domain.heroes.Role
import me.scraplesh.domain.heroes.Universe
import me.scraplesh.domain.heroes.filter.RoleFilter
import me.scraplesh.domain.heroes.filter.UniverseFilter
import me.scraplesh.hotsdraft.features.draft.DraftFeature.Wish
import me.scraplesh.hotsdraft.features.draft.DraftView.UiEvent
import me.scraplesh.mviflow.Bindings

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftBindings(coroutineScope: CoroutineScope, private val feature: DraftFeature) :
  Bindings<DraftView>(coroutineScope) {

  override fun setup(view: DraftView) {
    bind(view to feature using { uiEvent ->
      when (uiEvent) {
        is UiEvent.HeroSelected -> Wish.SelectHero(uiEvent.hero)
        UiEvent.AllUniversesChecked -> Wish.UncheckUniverses
        UiEvent.DiabloChecked -> Wish.CheckUniverse(Universe.Diablo)
        UiEvent.NexusChecked -> Wish.CheckUniverse(Universe.Nexus)
        UiEvent.OverwatchChecked -> Wish.CheckUniverse(Universe.Overwatch)
        UiEvent.StarcraftChecked -> Wish.CheckUniverse(Universe.Starcraft)
        UiEvent.WarcraftChecked -> Wish.CheckUniverse(Universe.Warcraft)
        UiEvent.AllRolesChecked -> Wish.UncheckRoles
        UiEvent.BruiserChecked -> Wish.CheckRole(Role.Bruiser)
        UiEvent.HealerChecked -> Wish.CheckRole(Role.Healer)
        UiEvent.MeleeAssassinChecked -> Wish.CheckRole(Role.MeleeAssassin)
        UiEvent.RangedAssassinChecked -> Wish.CheckRole(Role.RangedAssassin)
        UiEvent.SupportChecked -> Wish.CheckRole(Role.Support)
        UiEvent.TankChecked -> Wish.CheckRole(Role.Tank)
      }
    })
    bind(feature to view using { state ->
      DraftView.ViewModel(
        battleground = state.draft.battleground,
        heroes = state.filteredHeroes,
        allUniversesChecked = state.filters.none { filter -> filter is UniverseFilter },
        diabloChecked = state.filters
          .any { filter -> filter is UniverseFilter && filter.universe == Universe.Diablo },
        nexusChecked = state.filters
          .any { filter -> filter is UniverseFilter && filter.universe == Universe.Nexus },
        overwatchChecked = state.filters
          .any { filter -> filter is UniverseFilter && filter.universe == Universe.Overwatch },
        starcraftChecked = state.filters
          .any { filter -> filter is UniverseFilter && filter.universe == Universe.Starcraft },
        warcraftChecked = state.filters
          .any { filter -> filter is UniverseFilter && filter.universe == Universe.Warcraft },
        allRolesChecked = state.filters.none { filter -> filter is RoleFilter },
        bruiserChecked = state.filters
          .any { filter -> filter is RoleFilter && filter.role == Role.Bruiser },
        healerChecked = state.filters
          .any { filter -> filter is RoleFilter && filter.role == Role.Healer },
        meleeAssassinChecked = state.filters
          .any { filter -> filter is RoleFilter && filter.role == Role.MeleeAssassin },
        rangedAssassinChecked = state.filters
          .any { filter -> filter is RoleFilter && filter.role == Role.RangedAssassin },
        supportChecked = state.filters
          .any { filter -> filter is RoleFilter && filter.role == Role.Support },
        tankChecked = state.filters
          .any { filter -> filter is RoleFilter && filter.role == Role.Tank },
        yourPick1 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Pick && action.player == Player.First
        }?.third,
        isYourPick1Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        isYourPick1Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        yourPick2 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Pick && action.player == Player.Second
        }?.third,
        isYourPick2Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        isYourPick2Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        yourPick3 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Pick && action.player == Player.Third
        }?.third,
        isYourPick3Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        isYourPick3Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        yourPick4 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Pick && action.player == Player.Forth
        }?.third,
        isYourPick4Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        isYourPick4Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        yourPick5 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Pick && action.player == Player.Fifth
        }?.third,
        isYourPick5Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        isYourPick5Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        yourBan1 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Ban && action.banPosition == BanPosition.First
        }?.third,
        isYourBan1Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        isYourBan1Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        yourBan2 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Ban && action.banPosition == BanPosition.Second
        }?.third,
        isYourBan2Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        isYourBan2Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        yourBan3 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Your && action is DraftAction.Ban && action.banPosition == BanPosition.Third
        }?.third,
        isYourBan3Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false,
        isYourBan3Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false,
        enemyPick1 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Pick && action.player == Player.First
        }?.third,
        isEnemyPick1Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        isEnemyPick1Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        enemyPick2 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Second
        }?.third,
        isEnemyPick2Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        isEnemyPick2Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        enemyPick3 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Third
        }?.third,
        isEnemyPick3Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        isEnemyPick3Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        enemyPick4 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Forth
        }?.third,
        isEnemyPick4Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        isEnemyPick4Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        enemyPick5 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Pick && action.player == Player.Fifth
        }?.third,
        isEnemyPick5Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        isEnemyPick5Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        enemyBan1 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Ban && action.banPosition == BanPosition.First
        }?.third,
        isEnemyBan1Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        isEnemyBan1Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        enemyBan2 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Ban && action.banPosition == BanPosition.Second
        }?.third,
        isEnemyBan2Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        isEnemyBan2Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        enemyBan3 = state.draft.draftedHeroes.firstOrNull { (team, action, _) ->
          team == Team.Enemy && action is DraftAction.Ban && action.banPosition == BanPosition.Third
        }?.third,
        isEnemyBan3Current = state.draft.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false,
        isEnemyBan3Next = state.draft.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false
      )
    })
  }
}
