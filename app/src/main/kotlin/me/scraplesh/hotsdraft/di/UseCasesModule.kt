package me.scraplesh.hotsdraft.di

import me.scraplesh.domain.usecases.SelectHeroUseCase
import org.koin.dsl.module

val useCasesModule = module {
  factory { SelectHeroUseCase() }
}
