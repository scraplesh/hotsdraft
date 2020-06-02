package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftBindings(coroutineScope: CoroutineScope, private val viewModel: DraftViewModel) :
  AndroidBindings<DraftView>(coroutineScope) {

  override fun setup(view: DraftView) {
    bind(view to viewModel using { uiEvent ->
      when (uiEvent) {
        is DraftView.UiEvent.HeroSelected -> DraftViewModel.Wish.SelectHero(uiEvent.hero)
      }
    })
    bind(viewModel to view using { state ->
      DraftView.ViewModel(
        battleground = state.battleground,
        selectedUniverse = state.selectedUniverse,
        selectedRole = state.selectedRole,
        heroes = state.heroes,
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
