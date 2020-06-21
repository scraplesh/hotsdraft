package me.scraplesh.hotsdraft.domain.usecases

import kotlinx.coroutines.flow.Flow
import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository

class GetHeroesUseCase(private val repo: HeroesRepository) : UseCase {
  operator fun invoke(): Flow<List<Hero>> = repo.getHeroes()
}
