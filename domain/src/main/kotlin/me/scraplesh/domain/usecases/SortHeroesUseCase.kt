package me.scraplesh.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.sorter.HeroesSorter

class SortHeroesUseCase : UseCase {
  operator fun invoke(heroes: List<Hero>, sorters: List<HeroesSorter>): Flow<List<Hero>> =
    flowOf(heroes.sortedBy { hero -> sorters.sumBy { sorter -> sorter(hero) } })
}
