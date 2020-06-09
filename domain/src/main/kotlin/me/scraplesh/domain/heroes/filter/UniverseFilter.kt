package me.scraplesh.domain.heroes.filter

import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.Universe

class UniverseFilter(val universe: Universe) : HeroesFilter {
  override fun invoke(hero: Hero): Boolean = hero.universe == universe
}
