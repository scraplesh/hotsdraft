package me.scraplesh.hotsdraft.di

import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.hotsdraft.common.navigation.Coordinator
import me.scraplesh.hotsdraft.navigation.RootCoordinator
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val navigationModule = module {
  val cicerone = Cicerone.create()
  single { cicerone.router }
  single { RootCoordinator(router = get()) } bind Coordinator::class
  single { cicerone.navigatorHolder }
  factory<Navigator> { (activity: FragmentActivity, containerId: Int) ->
    SupportAppNavigator(activity, containerId)
  }
}
