package me.scraplesh.hotsdraft.domain.usecases

import kotlinx.coroutines.flow.Flow
import me.scraplesh.hotsdraft.domain.entity.HeroEntity
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository

class GetHeroesUseCase(private val repo: HeroesRepository) : UseCase {
  suspend operator fun invoke(): Flow<List<HeroEntity>> = repo.getHeroes()
}
