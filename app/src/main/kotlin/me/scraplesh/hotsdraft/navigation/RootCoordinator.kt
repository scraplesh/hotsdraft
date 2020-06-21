package me.scraplesh.hotsdraft.navigation

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.hotsdraft.common.navigation.Coordinator
import me.scraplesh.hotsdraft.common.navigation.NavigationEvent
import me.scraplesh.hotsdraft.features.lot.FirstTeamSelectedNavigationEvent
import me.scraplesh.hotsdraft.features.selectbattleground.BattlegroundSelected
import ru.terrakok.cicerone.Router

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class RootCoordinator(private val router: Router) : Coordinator {
  override fun accept(t: NavigationEvent) {
    when (t) {
      HotsDraftNavigationEvent.ApplicationStarted -> {
        router.newRootScreen(HotsDraftScreen.Heroes)
      }
      is BattlegroundSelected -> router.navigateTo(HotsDraftScreen.Lot(t.battleground))
      is FirstTeamSelectedNavigationEvent -> {
        router.replaceScreen(HotsDraftScreen.Draft(t.battleground, t.team))
      }
    }
  }
}
