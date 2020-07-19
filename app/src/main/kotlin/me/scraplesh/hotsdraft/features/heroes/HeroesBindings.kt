package me.scraplesh.hotsdraft.features.heroes

import kotlinx.coroutines.CoroutineScope
import me.scraplesh.mviflow.Bindings

class HeroesBindings(coroutineScope: CoroutineScope, private val feature: HeroesFeature) :
  Bindings<HeroesView>(coroutineScope) {

  override fun setup(view: HeroesView) {
    bind(view to feature using { uiEvent ->
      when (uiEvent) {
        HeroesView.UiEvent.AllUniversesChecked -> TODO()
        HeroesView.UiEvent.DiabloChecked -> TODO()
        HeroesView.UiEvent.NexusChecked -> TODO()
        HeroesView.UiEvent.OverwatchChecked -> TODO()
        HeroesView.UiEvent.StarcraftChecked -> TODO()
        HeroesView.UiEvent.WarcraftChecked -> TODO()
        HeroesView.UiEvent.AllRolesChecked -> TODO()
        HeroesView.UiEvent.BruiserChecked -> TODO()
        HeroesView.UiEvent.HealerChecked -> TODO()
        HeroesView.UiEvent.MeleeAssassinChecked -> TODO()
        HeroesView.UiEvent.RangedAssassinChecked -> TODO()
        HeroesView.UiEvent.SupportChecked -> TODO()
        HeroesView.UiEvent.TankChecked -> TODO()
        HeroesView.UiEvent.Created -> TODO()
      }
    })
    bind(feature to view using { state ->
      HeroesView.ViewModel(
        heroes = state.heroes,
        allUniversesChecked = false,
        diabloChecked = false,
        nexusChecked = false,
        overwatchChecked = false,
        starcraftChecked = false,
        warcraftChecked = false,
        allRolesChecked = false,
        healerChecked = false,
        meleeAssassinChecked = false,
        rangedAssassinChecked = false,
        supportChecked = false,
        tankChecked = false,
        bruiserChecked = false
      )
    })
  }
}
