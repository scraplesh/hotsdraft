package me.scraplesh.hotsdraft.features.draft

import androidx.lifecycle.ViewModelStoreOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.draft.DraftOrder
import me.scraplesh.domain.draft.Team
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.android.viewmodel.scope.getViewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
val draftModule = module {
  scope<DraftFragment> {
    viewModel { (battleground: Battleground, teamStarts: Team) ->
      DraftViewModel(
        DraftViewModel.State(
          battleground = battleground,
          actions = when (teamStarts) {
            Team.Your -> DraftOrder.YourTeamStarts
            Team.Enemy -> DraftOrder.EnemyTeamStarts
          }.actions
        )
      )
    }
    scoped<AndroidBindings<DraftView>> { (
                                           owner: ViewModelStoreOwner,
                                           coroutineScope: CoroutineScope,
                                           battleground: Battleground,
                                           teamStarts: Team
                                         ) ->
      DraftBindings(
        coroutineScope,
        getViewModel(owner, DraftViewModel::class) { parametersOf(battleground, teamStarts) }
      )
    }
    scoped { (coroutineScope: CoroutineScope) -> DraftView(coroutineScope) }
  }
}
