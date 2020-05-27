package me.scraplesh.domain.draft

enum class DraftOrder(val actions: List<Pair<Team, DraftAction>>) {
    YourTeamStarts(
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
