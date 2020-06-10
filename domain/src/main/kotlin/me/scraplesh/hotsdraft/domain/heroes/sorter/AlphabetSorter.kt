package me.scraplesh.hotsdraft.domain.heroes.sorter

import me.scraplesh.hotsdraft.domain.heroes.Hero

class AlphabetSorter : HeroesSorter {
  override fun invoke(hero: Hero): Int = Hero.values().size - hero.ordinal
}
