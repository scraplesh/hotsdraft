package me.scraplesh.hotsdraft.domain.heroes.sorter

import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.domain.heroes.BattlegroundCompliance
import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.heroes.getBattlegroundCompliance

class WeakBattlegroundSorter(private val battleground: Battleground) : HeroesSorter {
  override fun invoke(hero: Hero): Int = when (hero.getBattlegroundCompliance(battleground)) {
    BattlegroundCompliance.Strong -> 0
    BattlegroundCompliance.Average -> 1
    BattlegroundCompliance.Weak -> 2
    BattlegroundCompliance.Unknown -> 0
  }
}
