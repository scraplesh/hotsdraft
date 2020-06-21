package me.scraplesh.hotsdraft.features.selectbattleground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.scraplesh.hotsdraft.common.navigation.Coordinator
import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.features.selectbattleground.databinding.FragmentSelectbattlegroundBinding
import org.koin.android.ext.android.inject

class SelectBattlegroundFragment : Fragment() {
  private lateinit var binding: FragmentSelectbattlegroundBinding
  private val coordinator: Coordinator by inject()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? = FragmentSelectbattlegroundBinding.inflate(inflater, container, false)
    .also { binding -> this.binding = binding }
    .root

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.cardviewSelectbattlegroundAlteracPass.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.AlteracPass))
    }
    binding.cardviewSelectbattlegroundBattlefieldOfEternity.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.BattlefieldOfEternity))
    }
    binding.cardviewSelectbattlegroundBlackheartsBay.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.BlackheartsBay))
    }
    binding.cardviewSelectbattlegroundBraxisHoldout.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.BraxisHoldout))
    }
    binding.cardviewSelectbattlegroundCursedHollow.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.CursedHollow))
    }
    binding.cardviewSelectbattlegroundDragonShire.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.DragonShire))
    }
    binding.cardviewSelectbattlegroundGardenOfTerror.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.GardenOfTerror))
    }
    binding.cardviewSelectbattlegroundHanamuraTemple.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.HanamuraTemple))
    }
    binding.cardviewSelectbattlegroundHauntedMines.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.HauntedMines))
    }
    binding.cardviewSelectbattlegroundInfernalShrines.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.InfernalShrines))
    }
    binding.cardviewSelectbattlegroundSkyTemple.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.SkyTemple))
    }
    binding.cardviewSelectbattlegroundTombOfTheSpiderQueen.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.TombOfTheSpiderQueen))
    }
    binding.cardviewSelectbattlegroundTowersOfDoom.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.TowersOfDoom))
    }
    binding.cardviewSelectbattlegroundVolskayaFoundry.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.VolskayaFoundry))
    }
    binding.cardviewSelectbattlegroundWarheadJunction.setOnClickListener {
      coordinator.accept(BattlegroundSelected(Battleground.WarheadJunction))
    }
  }
}
