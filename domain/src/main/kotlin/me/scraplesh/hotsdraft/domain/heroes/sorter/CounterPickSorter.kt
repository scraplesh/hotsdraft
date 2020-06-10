package me.scraplesh.hotsdraft.domain.heroes.sorter

import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.heroes.counteredBy

class CounterPickSorter(private val counterHero: Hero) : HeroesSorter {
  override fun invoke(hero: Hero): Int = if (hero in counterHero.counteredBy) 1 else 0
}
