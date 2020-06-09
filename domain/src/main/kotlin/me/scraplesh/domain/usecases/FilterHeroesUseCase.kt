package me.scraplesh.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.filter.HeroesFilter

class FilterHeroesUseCase : UseCase {
  operator fun invoke(heroes: List<Hero>, filters: List<HeroesFilter>): Flow<List<Hero>> =
    flowOf(heroes.filter { hero -> filters.all { filter -> filter(hero) } })
}
