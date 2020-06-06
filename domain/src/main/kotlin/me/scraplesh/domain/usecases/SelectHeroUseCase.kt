package me.scraplesh.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.domain.Hero
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.draft.DraftedHero

class SelectHeroUseCase : UseCase {
  operator fun invoke(hero: Hero, draft: Draft): Flow<Draft> = flowOf(
    draft.currentAction
      ?.let { (team, action) ->
        draft.copy(
          currentActionIndex = draft.currentActionIndex + 1,
          draftedHeroes = draft.draftedHeroes + DraftedHero(
            team,
            action,
            hero
          )
        )
      }
      ?: draft
  )
}
