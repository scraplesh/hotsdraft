package me.scraplesh.hotsdraft.domain.draft

enum class DraftOrder(val actions: List<Pair<Team, DraftAction>>) {
    YourTeamStarts(
        actions = listOf(
            Team.Your to DraftAction.Ban(BanPosition.First),
            Team.Enemy to DraftAction.Ban(BanPosition.First),
            Team.Your to DraftAction.Ban(BanPosition.Second),
            Team.Enemy to DraftAction.Ban(BanPosition.Second),
            Team.Your to DraftAction.Pick(Player.First),
            Team.Enemy to DraftAction.Pick(Player.First),
            Team.Enemy to DraftAction.Pick(Player.Second),
            Team.Your to DraftAction.Pick(Player.Second),
            Team.Your to DraftAction.Pick(Player.Third),
            Team.Enemy to DraftAction.Ban(BanPosition.Third),
            Team.Your to DraftAction.Ban(BanPosition.Third),
            Team.Enemy to DraftAction.Pick(Player.Third),
            Team.Enemy to DraftAction.Pick(Player.Forth),
            Team.Your to DraftAction.Pick(Player.Forth),
            Team.Your to DraftAction.Pick(Player.Fifth),
            Team.Enemy to DraftAction.Pick(Player.Fifth)
        )
    ),
    EnemyTeamStarts(
        actions = listOf(
            Team.Enemy to DraftAction.Ban(BanPosition.First),
            Team.Your to DraftAction.Ban(BanPosition.First),
            Team.Enemy to DraftAction.Ban(BanPosition.Second),
            Team.Your to DraftAction.Ban(BanPosition.Second),
            Team.Enemy to DraftAction.Pick(Player.First),
            Team.Your to DraftAction.Pick(Player.First),
            Team.Your to DraftAction.Pick(Player.Second),
            Team.Enemy to DraftAction.Pick(Player.Second),
            Team.Enemy to DraftAction.Pick(Player.Third),
            Team.Your to DraftAction.Ban(BanPosition.Third),
            Team.Enemy to DraftAction.Ban(BanPosition.Third),
            Team.Your to DraftAction.Pick(Player.Third),
            Team.Your to DraftAction.Pick(Player.Forth),
            Team.Enemy to DraftAction.Pick(Player.Forth),
            Team.Enemy to DraftAction.Pick(Player.Fifth),
            Team.Your to DraftAction.Pick(Player.Fifth)
        )
    )
}
