package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.domain.draft.Draft
import me.scraplesh.hotsdraft.domain.draft.Team
import me.scraplesh.mviflow.Bindings
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val draftModule = module {
  factory { (battleground: Battleground, teamStarts: Team) -> Draft(battleground, teamStarts) }

  scope<DraftFragment> {
    scoped { (battleground: Battleground, teamStarts: Team) ->
      DraftFeature(
        initialState = DraftFeature.State(draft = get { parametersOf(battleground, teamStarts) }),
        selectHeroUseCase = get(),
        sortHeroesUseCase = get(),
        filterHeroesUseCase = get(),
        analyzeDraftUseCase = get()
      )
    }
    scoped<Bindings<DraftView>> { (
                                    coroutineScope: CoroutineScope,
                                    battleground: Battleground,
                                    teamStarts: Team
                                  ) ->
      DraftBindings(
        coroutineScope = coroutineScope,
        feature = get { parametersOf(battleground, teamStarts) }
      )
    }
    scoped { (coroutineScope: CoroutineScope) -> DraftView(coroutineScope) }
  }
}
