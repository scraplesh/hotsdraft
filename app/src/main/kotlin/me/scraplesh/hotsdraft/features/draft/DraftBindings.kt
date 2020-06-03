package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.Role
import me.scraplesh.domain.Universe
import me.scraplesh.domain.draft.BanPosition
import me.scraplesh.domain.draft.DraftAction
import me.scraplesh.domain.draft.Player
import me.scraplesh.domain.draft.Team
import me.scraplesh.hotsdraft.features.draft.DraftView.UiEvent
import me.scraplesh.hotsdraft.features.draft.DraftViewModel.Wish

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftBindings(coroutineScope: CoroutineScope, private val viewModel: DraftViewModel) :
  AndroidBindings<DraftView>(coroutineScope) {

  override fun setup(view: DraftView) {
    bind(view to viewModel using { uiEvent ->
      when (uiEvent) {
        is UiEvent.HeroSelected -> Wish.SelectHero(uiEvent.hero)
        UiEvent.AllUniversesChecked -> Wish.CheckAllUniverses
        UiEvent.DiabloChecked -> Wish.CheckDiablo
        UiEvent.NexusChecked -> Wish.CheckNexus
        UiEvent.OverwatchChecked -> Wish.CheckOverwatch
        UiEvent.StarcraftChecked -> Wish.CheckStarcraft
        UiEvent.WarcraftChecked -> Wish.CheckWarcraft
        UiEvent.AllRolesChecked -> Wish.CheckAllRoles
        UiEvent.BruiserChecked -> Wish.CheckBruiser
        UiEvent.HealerChecked -> Wish.CheckHealer
        UiEvent.MeleeAssassinChecked -> Wish.CheckMeleeAssassin
        UiEvent.RangedAssassinChecked -> Wish.CheckRangedAssassin
        UiEvent.SupportChecked -> Wish.CheckSupport
        UiEvent.TankChecked -> Wish.CheckTank
      }
    })
    bind(viewModel to view using { state ->
//      team == Team.Your &&
//          action is DraftAction.Pick &&
//          action.player == Player.First
      DraftView.ViewModel(
        battleground = state.battleground,
        heroes = state.filteredHeroes,
        allUniversesChecked = state.selectedUniverse == null,
        diabloChecked = state.selectedUniverse == Universe.Diablo,
        nexusChecked = state.selectedUniverse == Universe.Nexus,
        overwatchChecked = state.selectedUniverse == Universe.Overwatch,
        starcraftChecked = state.selectedUniverse == Universe.Starcraft,
        warcraftChecked = state.selectedUniverse == Universe.Warcraft,
        allRolesChecked = state.selectedRole == null,
        bruiserChecked = state.selectedRole == Role.Bruiser,
        healerChecked = state.selectedRole == Role.Healer,
        meleeAssassinChecked = state.selectedRole == Role.MeleeAssassin,
        rangedAssassinChecked = state.selectedRole == Role.RangedAssassin,
        supportChecked = state.selectedRole == Role.Support,
        tankChecked = state.selectedRole == Role.Tank,
        yourPick1 = state.yourPick1,
        isYourPick1Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        isYourPick1Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        yourPick2 = state.yourPick2,
        isYourPick2Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        isYourPick2Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        yourPick3 = state.yourPick3,
        isYourPick3Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        isYourPick3Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        yourPick4 = state.yourPick4,
        isYourPick4Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        isYourPick4Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        yourPick5 = state.yourPick5,
        isYourPick5Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        isYourPick5Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        yourBan1 = state.yourBan1,
        isYourBan1Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        isYourBan1Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        yourBan2 = state.yourBan2,
        isYourBan2Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        isYourBan2Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        yourBan3 = state.yourBan3,
        isYourBan3Current = state.currentAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false,
        isYourBan3Next = state.nextAction?.let { (team, action) ->
          team == Team.Your &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false,
        enemyPick1 = state.enemyPick1,
        isEnemyPick1Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        isEnemyPick1Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.First
        } ?: false,
        enemyPick2 = state.enemyPick2,
        isEnemyPick2Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        isEnemyPick2Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Second
        } ?: false,
        enemyPick3 = state.enemyPick3,
        isEnemyPick3Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        isEnemyPick3Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Third
        } ?: false,
        enemyPick4 = state.enemyPick4,
        isEnemyPick4Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        isEnemyPick4Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Forth
        } ?: false,
        enemyPick5 = state.enemyPick5,
        isEnemyPick5Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        isEnemyPick5Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Pick &&
              action.player == Player.Fifth
        } ?: false,
        enemyBan1 = state.enemyBan1,
        isEnemyBan1Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        isEnemyBan1Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.First
        } ?: false,
        enemyBan2 = state.enemyBan2,
        isEnemyBan2Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        isEnemyBan2Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Second
        } ?: false,
        enemyBan3 = state.enemyBan3,
        isEnemyBan3Current = state.currentAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false,
        isEnemyBan3Next = state.nextAction?.let { (team, action) ->
          team == Team.Enemy &&
              action is DraftAction.Ban &&
              action.banPosition == BanPosition.Third
        } ?: false
      )
    })
  }
}
