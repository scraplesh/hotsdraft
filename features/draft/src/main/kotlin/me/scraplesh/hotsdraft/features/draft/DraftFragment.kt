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
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.hotsdraft.common.platform.argumentNotNull
import me.scraplesh.hotsdraft.features.draft.databinding.FragmentDraftBinding
import me.scraplesh.mviflow.Bindings
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
  private val bindings: Bindings<DraftView> by koinLifecycleScope.inject {
    parametersOf(lifecycleScope, battleground, teamStarts, ::getHeroName)
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

  private fun getHeroName(hero: Hero) = getString(
    when (hero) {
      Hero.Abathur -> R.string.abathur
      Hero.Alarak -> R.string.alarak
      Hero.Alexstrasza -> R.string.alexstrasza
      Hero.Ana -> R.string.ana
      Hero.Anduin -> R.string.anduin
      Hero.Anubarak -> R.string.anubarak
      Hero.Artanis -> R.string.artanis
      Hero.Arthas -> R.string.arthas
      Hero.Auriel -> R.string.auriel
      Hero.Azmodan -> R.string.azmodan
      Hero.Blaze -> R.string.blaze
      Hero.Brightwing -> R.string.brightwing
      Hero.Cassia -> R.string.cassia
      Hero.Chen -> R.string.chen
      Hero.Cho -> R.string.cho
      Hero.Chromie -> R.string.chromie
      Hero.Deathwing -> R.string.deathwing
      Hero.Deckard -> R.string.deckard
      Hero.Dehaka -> R.string.dehaka
      Hero.Diablo -> R.string.diablo
      Hero.DiVa -> R.string.di_va
      Hero.ETC -> R.string.etc
      Hero.Falstad -> R.string.falstad
      Hero.Fenix -> R.string.fenix
      Hero.Gall -> R.string.gall
      Hero.Garrosh -> R.string.garrosh
      Hero.Gazlowe -> R.string.gazlowe
      Hero.Genji -> R.string.genji
      Hero.Greymane -> R.string.greymane
      Hero.Guldan -> R.string.guldan
      Hero.Hanzo -> R.string.hanzo
      Hero.Illidan -> R.string.illidan
      Hero.Imperius -> R.string.imperius
      Hero.Jaina -> R.string.jaina
      Hero.Johanna -> R.string.johanna
      Hero.Junkrat -> R.string.junkrat
      Hero.Kaelthas -> R.string.kaelthas
      Hero.KelThuzad -> R.string.kel_thuzad
      Hero.Kerrigan -> R.string.kerrigan
      Hero.Kharazim -> R.string.kharazim
      Hero.Leoric -> R.string.leoric
      Hero.LiLi -> R.string.li_li
      Hero.LiMing -> R.string.li_ming
      Hero.LtMorales -> R.string.lt_morales
      Hero.Lucio -> R.string.lucio
      Hero.Lunara -> R.string.lunara
      Hero.Maiev -> R.string.maiev
      Hero.Malfurion -> R.string.malfurion
      Hero.MalGanis -> R.string.mal_ganis
      Hero.Malthael -> R.string.malthael
      Hero.Medivh -> R.string.medivh
      Hero.Mephisto -> R.string.mephisto
      Hero.Muradin -> R.string.muradin
      Hero.Murky -> R.string.murky
      Hero.Nazeebo -> R.string.nazeebo
      Hero.Nova -> R.string.nova
      Hero.Orphea -> R.string.orphea
      Hero.Probius -> R.string.probius
      Hero.Qhira -> R.string.qhira
      Hero.Ragnaros -> R.string.ragnaros
      Hero.Raynor -> R.string.raynor
      Hero.Rehgar -> R.string.rehgar
      Hero.Rexxar -> R.string.rexxar
      Hero.Samuro -> R.string.samuro
      Hero.SgtHammer -> R.string.sgt_hammer
      Hero.Sonya -> R.string.sonya
      Hero.Stitches -> R.string.stitches
      Hero.Stukov -> R.string.stukov
      Hero.Sylvanas -> R.string.sylvanas
      Hero.Tassadar -> R.string.tassadar
      Hero.TheButcher -> R.string.the_butcher
      Hero.TheLostVikings -> R.string.the_lost_vikings
      Hero.Thrall -> R.string.thrall
      Hero.Tracer -> R.string.tracer
      Hero.Tychus -> R.string.tychus
      Hero.Tyrael -> R.string.tyrael
      Hero.Tyrande -> R.string.tyrande
      Hero.Uther -> R.string.uther
      Hero.Valeera -> R.string.valeera
      Hero.Valla -> R.string.valla
      Hero.Varian -> R.string.varian
      Hero.Whitemane -> R.string.whitemane
      Hero.Xul -> R.string.xul
      Hero.Yrel -> R.string.yrel
      Hero.Zagara -> R.string.zagara
      Hero.Zarya -> R.string.zarya
      Hero.Zeratul -> R.string.zeratul
      Hero.Zuljin -> R.string.zuljin
    }
  )

}
