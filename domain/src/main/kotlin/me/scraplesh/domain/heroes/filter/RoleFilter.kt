package me.scraplesh.domain.heroes.filter

import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.Role

class RoleFilter(val role: Role) : HeroesFilter {
  override fun invoke(hero: Hero): Boolean = hero.role == role
}
