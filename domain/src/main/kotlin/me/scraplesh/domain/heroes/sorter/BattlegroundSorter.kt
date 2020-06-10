package me.scraplesh.domain.heroes.sorter

import me.scraplesh.domain.Battleground
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.getBattlegroundCompliance

class BattlegroundSorter(private val battleground: Battleground) : HeroesSorter {
  override fun invoke(hero: Hero): Int =
    Int.MAX_VALUE - hero.getBattlegroundCompliance(battleground).ordinal + 1
}
