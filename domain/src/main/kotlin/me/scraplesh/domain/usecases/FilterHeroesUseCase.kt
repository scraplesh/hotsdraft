package me.scraplesh.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.domain.heroes.Hero

class FilterHeroesUseCase : UseCase {
  operator fun invoke(heroes: List<Hero>): Flow<List<Hero>> = flowOf(emptyList())
}
