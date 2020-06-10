package me.scraplesh.hotsdraft.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.hotsdraft.domain.draft.Draft
import me.scraplesh.hotsdraft.domain.draft.DraftAction
import me.scraplesh.hotsdraft.domain.draft.Team
import me.scraplesh.hotsdraft.domain.heroes.sorter.*

class AnalyzedDraftUseCase : UseCase {
  operator fun invoke(draft: Draft): Flow<List<HeroesSorter>> = flowOf(
    draft.currentAction?.let { (team, _) ->
      when (team) {
        Team.Your -> getSynergySorters(draft)
        Team.Enemy -> getCounterSorters()
      }
    }
      ?: when (draft.teamStarts) {
        Team.Your -> listOf<HeroesSorter>(StrongBattlegroundSorter(draft.battleground))
        Team.Enemy -> emptyList()
      }
  )

  private fun getSynergySorters(draft: Draft): List<HeroesSorter> {
    return mutableListOf<HeroesSorter>().apply {
      add(StrongBattlegroundSorter(draft.battleground))
      draft.draftedHeroes.forEach { (team, draftAction, hero) ->
        when (team) {
          Team.Your -> when (draftAction) {
            is DraftAction.Ban -> {
            }
            is DraftAction.Pick -> add(SynergySorter(hero))
          }
          Team.Enemy -> when (draftAction) {
            is DraftAction.Ban -> {
            }
            is DraftAction.Pick -> add(CounterPickSorter(hero))
          }
        }
      }
    }
  }

  private fun getCounterSorters(): List<HeroesSorter> = listOf(AlphabetSorter())
}
