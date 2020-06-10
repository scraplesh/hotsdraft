package me.scraplesh.hotsdraft.domain.heroes.sorter

import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.heroes.synergyHeroes

class SynergySorter(private val withHero: Hero) : HeroesSorter {
  override fun invoke(hero: Hero): Int = if (hero in withHero.synergyHeroes) 1 else 0
}
