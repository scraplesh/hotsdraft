package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.draft.Team
import me.scraplesh.mviflow.Bindings
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
val draftModule = module {
  factory { (battleground: Battleground, teamStarts: Team) -> Draft(battleground, teamStarts) }

  scope<DraftFragment> {
    scoped { (coroutineScope: CoroutineScope, battleground: Battleground, teamStarts: Team) ->
      DraftFeature(
        coroutineScope = coroutineScope,
        initialState = DraftFeature.State(draft = get { parametersOf(battleground, teamStarts) }),
        selectHeroUseCase = get(),
        sortHeroes = get(),
        filterHeroes = get()
      )
    }
    scoped<Bindings<DraftView>> { (
                                    coroutineScope: CoroutineScope,
                                    battleground: Battleground,
                                    teamStarts: Team
                                  ) ->
      DraftBindings(
        coroutineScope = coroutineScope,
        feature = get { parametersOf(coroutineScope, battleground, teamStarts) }
      )
    }
    scoped { (coroutineScope: CoroutineScope) -> DraftView(coroutineScope) }
  }
}
