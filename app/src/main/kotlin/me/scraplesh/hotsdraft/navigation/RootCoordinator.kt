package me.scraplesh.hotsdraft.navigation

import ru.terrakok.cicerone.Router

class RootCoordinator(private val router: Router) : Coordinator {
    override fun accept(event: NavigationEvent) {
        when (event) {
            HotsDraftNavigationEvent.ApplicationStarted -> {
                router.newRootScreen(HotsDraftScreen.SelectBattleground)
            }
        }
    }
}
