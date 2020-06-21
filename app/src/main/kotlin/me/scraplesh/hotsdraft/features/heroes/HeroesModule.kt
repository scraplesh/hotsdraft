package me.scraplesh.hotsdraft.features.heroes

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.hotsdraft.data.WebCrawler
import me.scraplesh.mviflow.Bindings
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
val heroesModule = module {
  factory { (context: Context) -> WebCrawler(context) }

  scope<HeroesFragment> {
    scoped { (context: Context) ->
      HeroesFeature(
        initialState = HeroesFeature.State(),
        getHeroesUseCase = get { parametersOf(context) }
      )
    }
    scoped<Bindings<HeroesView>> { (coroutineScope: CoroutineScope, context: Context) ->
      HeroesBindings(
        coroutineScope = coroutineScope,
        feature = get { parametersOf(context) }
      )
    }
    scoped { (coroutineScope: CoroutineScope) -> HeroesView(coroutineScope) }
  }
}
