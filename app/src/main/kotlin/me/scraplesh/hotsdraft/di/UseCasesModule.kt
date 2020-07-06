package me.scraplesh.hotsdraft.di

import me.scraplesh.hotsdraft.domain.usecases.*
import org.koin.dsl.module

val useCasesModule = module {
  factory { SelectHeroUseCase() }
  factory { SortHeroesUseCase() }
  factory { FilterHeroesUseCase() }
  factory { AnalyzedDraftUseCase() }
  factory { GetHeroesUseCase(get()) }
}
