package me.scraplesh.hotsdraft.di

import me.scraplesh.domain.usecases.FilterHeroesUseCase
import me.scraplesh.domain.usecases.SelectHeroUseCase
import me.scraplesh.domain.usecases.SortHeroesUseCase
import org.koin.dsl.module

val useCasesModule = module {
  factory { SelectHeroUseCase() }
  factory { SortHeroesUseCase() }
  factory { FilterHeroesUseCase() }
}
