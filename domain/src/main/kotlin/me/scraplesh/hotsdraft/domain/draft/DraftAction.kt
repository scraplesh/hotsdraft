package me.scraplesh.hotsdraft.domain.draft

sealed class DraftAction {
  class Ban(val banPosition: BanPosition) : DraftAction()
  class Pick(val player: Player) : DraftAction()
}
