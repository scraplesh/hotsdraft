package me.scraplesh.hotsdraft.domain.repo

import kotlinx.coroutines.flow.Flow
import me.scraplesh.hotsdraft.domain.entity.HeroEntity

interface HeroesRepository : Repository {
  suspend fun getHeroes(): Flow<List<HeroEntity>>
}
