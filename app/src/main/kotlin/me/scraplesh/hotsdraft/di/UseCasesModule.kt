package me.scraplesh.hotsdraft.di

import android.content.Context
import me.scraplesh.hotsdraft.domain.usecases.*
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val useCasesModule = module {
  factory { SelectHeroUseCase() }
  factory { SortHeroesUseCase() }
  factory { FilterHeroesUseCase() }
  factory { AnalyzedDraftUseCase() }
  factory { (context: Context) -> GetHeroesUseCase(get { parametersOf(context) }) }
}
