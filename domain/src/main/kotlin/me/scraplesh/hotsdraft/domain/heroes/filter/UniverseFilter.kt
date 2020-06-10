package me.scraplesh.hotsdraft.domain.heroes.filter

import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.heroes.Universe

class UniverseFilter(val universe: Universe) : HeroesFilter {
  override fun invoke(hero: Hero): Boolean = hero.universe == universe
}
