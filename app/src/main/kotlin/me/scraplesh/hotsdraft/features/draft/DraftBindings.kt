package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.Role
import me.scraplesh.domain.Universe
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
        yourPick2 = state.yourPick2,
        yourPick3 = state.yourPick3,
        yourPick4 = state.yourPick4,
        yourPick5 = state.yourPick5,
        yourBan1 = state.yourBan1,
        yourBan2 = state.yourBan2,
        yourBan3 = state.yourBan3,
        enemyPick1 = state.enemyPick1,
        enemyPick2 = state.enemyPick2,
        enemyPick3 = state.enemyPick3,
        enemyPick4 = state.enemyPick4,
        enemyPick5 = state.enemyPick5,
        enemyBan1 = state.enemyBan1,
        enemyBan2 = state.enemyBan2,
        enemyBan3 = state.enemyBan3
      )
    })
  }
}
