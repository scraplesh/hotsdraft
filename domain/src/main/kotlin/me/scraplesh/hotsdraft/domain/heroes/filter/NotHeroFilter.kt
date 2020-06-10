package me.scraplesh.hotsdraft.domain.heroes.filter

import me.scraplesh.hotsdraft.domain.heroes.Hero

class NotHeroFilter(val hero: Hero) : HeroesFilter {
  override fun invoke(hero: Hero): Boolean = hero != this.hero
}
