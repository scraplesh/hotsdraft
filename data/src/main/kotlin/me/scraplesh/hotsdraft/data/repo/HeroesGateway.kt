package me.scraplesh.hotsdraft.data.repo

import kotlinx.coroutines.flow.Flow
import me.scraplesh.hotsdraft.data.datasource.OfficialWebsiteParser
import me.scraplesh.hotsdraft.domain.entity.HeroEntity
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository

class HeroesGateway(private val offSiteParser: OfficialWebsiteParser) : HeroesRepository {
  override suspend fun getHeroes(): Flow<List<HeroEntity>> = offSiteParser.getHeroes()
}
