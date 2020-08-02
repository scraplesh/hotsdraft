package me.scraplesh.hotsdraft.features.heroes

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import me.scraplesh.hotsdraft.data.WebCrawler
import me.scraplesh.hotsdraft.data.datasource.OfficialWebsiteParser
import me.scraplesh.mviflow.Bindings
import org.koin.dsl.module

val heroesModule = module {
  factory { (context: Context) -> OfficialWebsiteParser(WebCrawler(context)) }

  scope<HeroesFragment> {
    scoped<HeroesFeature> { getKoin().get() }
    scoped<Bindings<HeroesView>> { (coroutineScope: CoroutineScope) ->
      HeroesBindings(coroutineScope = coroutineScope, feature = get())
    }
    scoped { (coroutineScope: CoroutineScope) -> HeroesView(coroutineScope) }
  }
}
