package me.scraplesh.hotsdraft.features.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import me.scraplesh.hotsdraft.features.heroes.databinding.FragmentHeroesBinding
import me.scraplesh.mviflow.Bindings
import org.koin.core.parameter.parametersOf
import org.koin.androidx.scope.lifecycleScope as koinLifecycleScope

class HeroesFragment : Fragment() {
  private val mviView: HeroesView by koinLifecycleScope.inject { parametersOf(lifecycleScope) }
  private val bindings: Bindings<HeroesView> by koinLifecycleScope.inject {
    parametersOf(lifecycleScope, requireContext())
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    bindings.setup(mviView)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = mviView.getView(FragmentHeroesBinding.inflate(inflater, container, false))

}

