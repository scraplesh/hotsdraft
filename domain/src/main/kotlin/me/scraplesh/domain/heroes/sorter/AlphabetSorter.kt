package me.scraplesh.domain.heroes.sorter

import me.scraplesh.domain.heroes.Hero

class AlphabetSorter(private val getName: (Hero) -> String) : HeroesSorter {
  override fun invoke(hero: Hero): Int = getName(hero)[0].toInt()
}
