package me.scraplesh.hotsdraft.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.hotsdraft.data.WebCrawler
import me.scraplesh.hotsdraft.domain.entity.HeroEntity
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class OfficialWebsiteParser(private val crawler: WebCrawler) : DataSource {
  suspend fun getHeroes(): Flow<List<HeroEntity>> = flowOf(
    suspendCoroutine { cont ->
      crawler.loadPage("$BASE_URL$PATH_HEROES") { html ->
        cont.resume(parseHeroes(Jsoup.parse(html)))
      }
    }
  )

  private fun parseHeroes(document: Document): List<HeroEntity> =
    document.select(".HeroGrid-item")
      .mapNotNull(::parseHero)

  private fun parseHero(element: Element): HeroEntity? {
    val id: String? = getHeroId(element)
    val imgUrl: String? = getImgUrl(element)
    val name: String? = getHeroName(element)

    return if (id != null && imgUrl != null && name != null) {
      HeroEntity(id = id, imgUrl = imgUrl, name = name)
    } else {
      null
    }
  }

  private fun getHeroName(element: Element): String? {
    return element.select(".HeroName-text")
      ?.first()
      ?.text()
  }

  private fun getImgUrl(element: Element): String? = element.takeIf { it.childrenSize() > 0 }
    ?.child(0)
    ?.takeIf { it.childrenSize() > 0 }
    ?.child(0)
    ?.takeIf { it.childrenSize() > 0 }
    ?.child(0)
    ?.attr("src")
    ?.takeUnless { it.isEmpty() }

  private fun getHeroId(element: Element): String? {
    return element.attr("href")
      .takeUnless { it.isEmpty() }
      ?.split('/')
      ?.getOrNull(3)
  }

  private companion object {
    const val BASE_URL = "https://heroesofthestorm.com/en-us"
    const val PATH_HEROES = "/heroes/"
  }
}