package me.scraplesh.hotsdraft.di

import me.scraplesh.hotsdraft.domain.usecases.AnalyzedDraftUseCase
import me.scraplesh.hotsdraft.domain.usecases.FilterHeroesUseCase
import me.scraplesh.hotsdraft.domain.usecases.SelectHeroUseCase
import me.scraplesh.hotsdraft.domain.usecases.SortHeroesUseCase
import org.koin.dsl.module

val useCasesModule = module {
  factory { SelectHeroUseCase() }
  factory { SortHeroesUseCase() }
  factory { FilterHeroesUseCase() }
  factory { AnalyzedDraftUseCase() }
}
