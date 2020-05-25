package me.scraplesh.hotsdraft.navigation

import me.scraplesh.hotsdraft.common.navigation.Coordinator
import me.scraplesh.hotsdraft.common.navigation.NavigationEvent
import me.scraplesh.hotsdraft.features.selectbattleground.SelectBattlegroundNavigationEvent
import ru.terrakok.cicerone.Router

class RootCoordinator(private val router: Router) : Coordinator {
    override fun accept(t: NavigationEvent) {
        when (t) {
            HotsDraftNavigationEvent.ApplicationStarted -> {
                router.newRootScreen(HotsDraftScreen.SelectBattleground)
            }
            SelectBattlegroundNavigationEvent.AlteracPassSelected -> {
            }
        }
    }
}
