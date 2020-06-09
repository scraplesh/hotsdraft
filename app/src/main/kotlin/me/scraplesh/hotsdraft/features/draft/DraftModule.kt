package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.draft.Team
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.sorter.AlphabetSorter
import me.scraplesh.mviflow.Bindings
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
val draftModule = module {
  factory { (battleground: Battleground, teamStarts: Team) -> Draft(battleground, teamStarts) }

  scope<DraftFragment> {
    scoped { (
               coroutineScope: CoroutineScope,
               battleground: Battleground,
               teamStarts: Team,
               getHeroName: (Hero) -> String
             ) ->
      DraftFeature(
        coroutineScope = coroutineScope,
        initialState = DraftFeature.State(
          draft = get { parametersOf(battleground, teamStarts) },
          sorters = listOf(AlphabetSorter(getHeroName))
        ),
        selectHeroUseCase = get(),
        sortHeroes = get(),
        filterHeroes = get()
      )
    }
    scoped<Bindings<DraftView>> { (
                                    coroutineScope: CoroutineScope,
                                    battleground: Battleground,
                                    teamStarts: Team,
                                    getHeroName: (Hero) -> String
                                  ) ->
      DraftBindings(
        coroutineScope = coroutineScope,
        feature = get { parametersOf(coroutineScope, battleground, teamStarts, getHeroName) }
      )
    }
    scoped { (coroutineScope: CoroutineScope) -> DraftView(coroutineScope) }
  }
}
