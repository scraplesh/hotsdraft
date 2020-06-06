package me.scraplesh.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.scraplesh.domain.Hero
import me.scraplesh.domain.draft.Draft

class SortHeroesUseCase : UseCase {
  operator fun invoke(draft: Draft): Flow<List<Hero>> = flowOf(emptyList())
}
