package me.scraplesh.hotsdraft.features.draft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_draft.*
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.draft.Team
import me.scraplesh.hotsdraft.common.platform.argumentNotNull

class DraftFragment : Fragment() {

  companion object {
    fun newInstance(battleground: Battleground, team: Team) = DraftFragment().apply {
      this.battleground = battleground
      this.team = team
    }
  }

  private var battleground: Battleground by argumentNotNull()
  private var team: Team by argumentNotNull()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = inflater.inflate(R.layout.fragment_draft, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    imageview_draft_your_team_hero1
    imageview_draft_your_team_hero2
    imageview_draft_your_team_hero3
    imageview_draft_your_team_hero4
    imageview_draft_your_team_hero5
    imageview_draft_your_team_ban_hero1
    imageview_draft_your_team_ban_hero2
    imageview_draft_your_team_ban_hero3
    imageview_draft_enemy_team_hero1
    imageview_draft_enemy_team_hero2
    imageview_draft_enemy_team_hero3
    imageview_draft_enemy_team_hero4
    imageview_draft_enemy_team_hero5
    imageview_draft_enemy_team_ban_hero1
    imageview_draft_enemy_team_ban_hero2
    imageview_draft_enemy_team_ban_hero3
  }

}
