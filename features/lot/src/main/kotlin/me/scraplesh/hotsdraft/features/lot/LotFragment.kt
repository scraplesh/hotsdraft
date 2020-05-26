package me.scraplesh.hotsdraft.features.lot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_lot.*
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.draft.Team
import me.scraplesh.hotsdraft.common.navigation.Coordinator
import me.scraplesh.hotsdraft.common.platform.argumentNotNull
import org.koin.android.ext.android.inject

class LotFragment : Fragment() {

  companion object {
    fun newInstance(battleground: Battleground) =
      LotFragment().apply { this.battleground = battleground }
  }

  private val coordinator: Coordinator by inject()
  private var battleground: Battleground by argumentNotNull()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_lot, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    cardview_lot_your_team.setOnClickListener {
      coordinator.accept(FirstTeamSelectedNavigationEvent(Team.Your, battleground))
    }
    cardview_lot_enemy_team.setOnClickListener {
      coordinator.accept(FirstTeamSelectedNavigationEvent(Team.Enemy, battleground))
    }
  }
}
