package me.scraplesh.domain.draft

import me.scraplesh.domain.draft.Team

enum class DraftOrder(val teamStarts: Team, val actions: List<Pair<Team, DraftAction>>) {
    YourTeamStarts(
        Team.Your,
        actions = listOf(
            Team.Your to DraftAction.Ban,
            Team.Enemy to DraftAction.Ban,
            Team.Your to DraftAction.Ban,
            Team.Enemy to DraftAction.Ban,
            Team.Your to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Enemy to DraftAction.Ban,
            Team.Your to DraftAction.Ban,
            Team.Enemy to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick
        )
    ),
    EnemyTeamStarts(
        Team.Enemy,
        actions = listOf(
            Team.Enemy to DraftAction.Ban,
            Team.Your to DraftAction.Ban,
            Team.Enemy to DraftAction.Ban,
            Team.Your to DraftAction.Ban,
            Team.Enemy to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Your to DraftAction.Ban,
            Team.Enemy to DraftAction.Ban,
            Team.Your to DraftAction.Pick,
            Team.Your to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Enemy to DraftAction.Pick,
            Team.Your to DraftAction.Pick
        )
    )
}
