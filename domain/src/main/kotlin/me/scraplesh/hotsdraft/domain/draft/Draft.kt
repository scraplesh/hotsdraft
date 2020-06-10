package me.scraplesh.hotsdraft.domain.draft

import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.domain.heroes.Hero

typealias DraftedHero = Triple<Team, DraftAction, Hero>

data class Draft(
  val battleground: Battleground,
  val teamStarts: Team,
  val currentActionIndex: Int = 0,
  val draftedHeroes: List<DraftedHero> = emptyList()
) {
  private val actions: List<Pair<Team, DraftAction>>
    get() = when (teamStarts) {
      Team.Your -> DraftOrder.YourTeamStarts
      Team.Enemy -> DraftOrder.EnemyTeamStarts
    }.actions
  val currentAction get() = actions.getOrNull(currentActionIndex)
  val nextAction get() = actions.getOrNull(currentActionIndex + 1)
}
