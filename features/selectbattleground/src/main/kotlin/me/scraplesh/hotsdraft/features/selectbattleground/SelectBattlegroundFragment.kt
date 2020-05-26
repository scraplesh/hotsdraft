package me.scraplesh.hotsdraft.features.selectbattleground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_selectbattleground.*
import me.scraplesh.domain.Battleground
import me.scraplesh.hotsdraft.common.navigation.Coordinator
import org.koin.android.ext.android.inject

class SelectBattlegroundFragment : Fragment() {
    private val coordinator: Coordinator by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_selectbattleground, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardview_selectbattleground_alterac_pass.setOnClickListener {
            coordinator.accept(BattlegroundSelected(Battleground.AlteracPass))
        }
    }
}
