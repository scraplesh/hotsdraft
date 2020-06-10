package me.scraplesh.hotsdraft.domain.heroes.filter

import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.heroes.Role

class RoleFilter(val role: Role) : HeroesFilter {
  override fun invoke(hero: Hero): Boolean = hero.role == role
}
