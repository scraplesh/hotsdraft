package me.scraplesh.hotsdraft.features.draft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.draft.Team
import me.scraplesh.hotsdraft.common.platform.argumentNotNull
import me.scraplesh.hotsdraft.features.draft.databinding.FragmentDraftBinding
import org.koin.core.parameter.parametersOf
import org.koin.androidx.scope.lifecycleScope as koinLifecycleScope

@FlowPreview
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class DraftFragment : Fragment() {

  companion object {
    fun newInstance(battleground: Battleground, teamStarts: Team) = DraftFragment().apply {
      this.battleground = battleground
      this.teamStarts = teamStarts
    }
  }

  private var battleground: Battleground by argumentNotNull()
  private var teamStarts: Team by argumentNotNull()
  private val mviView: DraftView by koinLifecycleScope.inject { parametersOf(lifecycleScope) }
  private val bindings: AndroidBindings<DraftView> by koinLifecycleScope.inject {
    parametersOf(this, lifecycleScope, battleground, teamStarts)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindings.setup(mviView)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = mviView.getView(FragmentDraftBinding.inflate(inflater, container, false))

}
