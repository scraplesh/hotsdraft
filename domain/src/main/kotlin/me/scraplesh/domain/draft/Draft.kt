package me.scraplesh.domain.draft

import me.scraplesh.domain.Battleground
import me.scraplesh.domain.Consumer
import me.scraplesh.domain.Hero

class Draft(val battleground: Battleground, teamStarts: Team) : Consumer<Hero> {
  val team get() = actions.firstOrNull()?.first
  val action get() = actions.firstOrNull()?.second
  val yourTeamBanned: List<Hero>
    get() = draftedHeroes.filter { (team, action, _) -> team == Team.Your && action is DraftAction.Ban }
      .map { (_, _, hero) -> hero }
  val yourTeamPicked: List<Hero>
    get() = draftedHeroes.filter { (team, action, _) -> team == Team.Your && action is DraftAction.Pick }
      .map { (_, _, hero) -> hero }
  val enemyTeamBanned: List<Hero>
    get() = draftedHeroes.filter { (team, action, _) -> team == Team.Enemy && action is DraftAction.Ban }
      .map { (_, _, hero) -> hero }
  val enemyTeamPicked: List<Hero>
    get() = draftedHeroes.filter { (team, action, _) -> team == Team.Enemy && action is DraftAction.Pick }
      .map { (_, _, hero) -> hero }

  private val draftedHeroes: List<Triple<Team, DraftAction, Hero>> = mutableListOf()
  private var actions = when (teamStarts) {
    Team.Your -> DraftOrder.YourTeamStarts
    Team.Enemy -> DraftOrder.EnemyTeamStarts
  }.actions

  override fun accept(t: Hero) {
    if (actions.isNotEmpty()) {
      val (team, action) = actions.first()
      (draftedHeroes as MutableList<Triple<Team, DraftAction, Hero>>).add(Triple(team, action, t))

      actions = actions.drop(1)
    }
  }
}
