package me.scraplesh.hotsdraft.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository
import org.jsoup.Jsoup

class HeroesHearthHeroesRepository(private val crawler: WebCrawler) : HeroesRepository {
  override fun getHeroes(): Flow<List<Hero>> = flow {
    withContext(Dispatchers.IO) {
      crawler.loadPage("https://heroesofthestorm.com/en-us/heroes/") { html ->
        Jsoup.parse(html).run {
          select(".HeroGrid-item").map { element ->
            val a = 1
          }
        }
      }
    }
  }
}
