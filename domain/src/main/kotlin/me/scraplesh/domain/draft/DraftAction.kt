package me.scraplesh.domain.draft

sealed class DraftAction {
  class Ban(val banPosition: BanPosition) : DraftAction()
  class Pick(val player: Player) : DraftAction()
}
