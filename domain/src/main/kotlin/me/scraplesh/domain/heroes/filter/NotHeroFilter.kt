package me.scraplesh.domain.heroes.filter

import me.scraplesh.domain.heroes.Hero

class NotHeroFilter(val hero: Hero) : HeroesFilter {
  override fun invoke(hero: Hero): Boolean = hero != this.hero
}
