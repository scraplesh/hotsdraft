package me.scraplesh.hotsdraft.features.draft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import me.scraplesh.hotsdraft.common.platform.argumentNotNull
import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.domain.draft.Team
import me.scraplesh.hotsdraft.features.draft.databinding.FragmentDraftBinding
import me.scraplesh.mviflow.Bindings
import org.koin.core.parameter.parametersOf
import org.koin.androidx.scope.lifecycleScope as koinLifecycleScope

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
  private val bindings: Bindings<DraftView> by koinLifecycleScope.inject {
    parametersOf(lifecycleScope, battleground, teamStarts)
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
