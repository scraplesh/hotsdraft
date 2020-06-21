package me.scraplesh.hotsdraft.domain.repo

import kotlinx.coroutines.flow.Flow
import me.scraplesh.hotsdraft.domain.heroes.Hero

interface HeroesRepository : Repository {
  fun getHeroes(): Flow<List<Hero>>
}
