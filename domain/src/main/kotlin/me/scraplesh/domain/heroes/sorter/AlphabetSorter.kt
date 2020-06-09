package me.scraplesh.domain.heroes.sorter

import me.scraplesh.domain.heroes.Hero

class AlphabetSorter(private val getName: (Hero) -> String) : HeroesSorter {
  override fun invoke(heroes: List<Hero>): List<Hero> = heroes.sortedByDescending(getName)
}
