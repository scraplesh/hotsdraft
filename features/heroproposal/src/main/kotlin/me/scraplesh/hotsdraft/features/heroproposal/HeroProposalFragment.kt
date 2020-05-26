package me.scraplesh.hotsdraft.features.heroproposal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import kotlinx.android.synthetic.main.fragment_heroproposal.*
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.Hero
import me.scraplesh.domain.draft.Team
import me.scraplesh.hotsdraft.common.platform.argumentNotNull

class HeroProposalFragment : Fragment() {

  companion object {
    fun newInstance(battleground: Battleground, team: Team) = HeroProposalFragment().apply {
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
  ): View? = inflater.inflate(R.layout.fragment_heroproposal, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerview_draft.apply {
      layoutManager = GridLayoutManager(context, 4)
      adapter = ListDelegationAdapter(
        heroAdapterDelegate { hero ->
          Toast.makeText(context, "trololo", Toast.LENGTH_LONG).show()
        }
      )
        .apply { items = Hero.values().map { Item.HeroItem(it) } }

    }
  }

  private fun heroAdapterDelegate(itemClickListener: (Hero) -> Unit) =
    adapterDelegate<Item.HeroItem, Item>(R.layout.item_hero) {
      val heroImage: ImageView = findViewById(R.id.imageview_itemhero)
      heroImage.setOnClickListener { itemClickListener(item.hero) } // Item is automatically set for you. It's set lazily though (set in onBindViewHolder()). So only use it for deferred calls like clickListeners.

      bind {
        heroImage.setImageResource(
          when (item.hero) {
            Hero.Abathur -> R.drawable.hero_abathur
            Hero.Alarak -> R.drawable.hero_alarak
            Hero.Alexstrasza -> R.drawable.hero_alexstrasza
            Hero.Ana -> R.drawable.hero_ana
            Hero.Anduin -> R.drawable.hero_anduin
            Hero.Anubarak -> R.drawable.hero_anubarak
            Hero.Artanis -> R.drawable.hero_artanis
            Hero.Arthas -> R.drawable.hero_arthas
            Hero.Auriel -> R.drawable.hero_auriel
            Hero.Azmodan -> R.drawable.hero_azmodan
            Hero.Blaze -> R.drawable.hero_blaze
            Hero.Brightwing -> R.drawable.hero_brightwing
            Hero.Cassia -> R.drawable.hero_cassia
            Hero.Chen -> R.drawable.hero_chen
            Hero.Cho -> R.drawable.hero_cho
            Hero.Chromie -> R.drawable.hero_chromie
            Hero.Deathwing -> R.drawable.hero_deathwing
            Hero.Deckard -> R.drawable.hero_deckard
            Hero.Dehaka -> R.drawable.hero_dehaka
            Hero.Diablo -> R.drawable.hero_diablo
            Hero.DiVa -> R.drawable.hero_diva
            Hero.ETC -> R.drawable.hero_etc
            Hero.Falstad -> R.drawable.hero_falstad
            Hero.Fenix -> R.drawable.hero_fenix
            Hero.Gall -> R.drawable.hero_gall
            Hero.Garrosh -> R.drawable.hero_garrosh
            Hero.Gazlowe -> R.drawable.hero_gazlowe
            Hero.Genji -> R.drawable.hero_genji
            Hero.Greymane -> R.drawable.hero_greymane
            Hero.Guldan -> R.drawable.hero_guldan
            Hero.Hanzo -> R.drawable.hero_hanzo
            Hero.Illidan -> R.drawable.hero_illidan
            Hero.Imperius -> R.drawable.hero_imperius
            Hero.Jaina -> R.drawable.hero_jaina
            Hero.Johanna -> R.drawable.hero_johanna
            Hero.Junkrat -> R.drawable.hero_junkrat
            Hero.Kaelthas -> R.drawable.hero_kaelthas
            Hero.KelThuzad -> R.drawable.hero_kelthuzad
            Hero.Kerrigan -> R.drawable.hero_kerrigan
            Hero.Kharazim -> R.drawable.hero_kharazim
            Hero.Leoric -> R.drawable.hero_leoric
            Hero.LiLi -> R.drawable.hero_lili
            Hero.LiMing -> R.drawable.hero_liming
            Hero.LtMorales -> R.drawable.hero_ltmorales
            Hero.Lucio -> R.drawable.hero_lucio
            Hero.Lunara -> R.drawable.hero_lunara
            Hero.Maiev -> R.drawable.hero_maiev
            Hero.Malfurion -> R.drawable.hero_malfurion
            Hero.MalGanis -> R.drawable.hero_malganis
            Hero.Malthael -> R.drawable.hero_malthael
            Hero.Medivh -> R.drawable.hero_medivh
            Hero.Mephisto -> R.drawable.hero_mephisto
            Hero.Muradin -> R.drawable.hero_muradin
            Hero.Murky -> R.drawable.hero_murky
            Hero.Nazeebo -> R.drawable.hero_nazeebo
            Hero.Nova -> R.drawable.hero_nova
            Hero.Orphea -> R.drawable.hero_orphea
            Hero.Probius -> R.drawable.hero_probius
            Hero.Qhira -> R.drawable.hero_qhira
            Hero.Ragnaros -> R.drawable.hero_ragnaros
            Hero.Raynor -> R.drawable.hero_raynor
            Hero.Rehgar -> R.drawable.hero_rehgar
            Hero.Rexxar -> R.drawable.hero_rexxar
            Hero.Samuro -> R.drawable.hero_samuro
            Hero.SgtHammer -> R.drawable.hero_sgthammer
            Hero.Sonya -> R.drawable.hero_sonya
            Hero.Stitches -> R.drawable.hero_stitches
            Hero.Stukov -> R.drawable.hero_stukov
            Hero.Sylvanas -> R.drawable.hero_sylvanas
            Hero.Tassadar -> R.drawable.hero_tassadar
            Hero.TheButcher -> R.drawable.hero_thebutcher
            Hero.TheLostVikings -> R.drawable.hero_thelostvikings
            Hero.Thrall -> R.drawable.hero_thrall
            Hero.Tracer -> R.drawable.hero_tracer
            Hero.Tychus -> R.drawable.hero_tychus
            Hero.Tyrael -> R.drawable.hero_tyrael
            Hero.Tyrande -> R.drawable.hero_tyrande
            Hero.Uther -> R.drawable.hero_uther
            Hero.Valeera -> R.drawable.hero_valeera
            Hero.Valla -> R.drawable.hero_valla
            Hero.Varian -> R.drawable.hero_varian
            Hero.Whitemane -> R.drawable.hero_whitemane
            Hero.Xul -> R.drawable.hero_xul
            Hero.Yrel -> R.drawable.hero_yrel
            Hero.Zagara -> R.drawable.hero_zagara
            Hero.Zarya -> R.drawable.hero_zarya
            Hero.Zeratul -> R.drawable.hero_zeratul
            Hero.Zuljin -> R.drawable.hero_zuljin
          }
        )
        // This is called anytime onBindViewHolder() is called
//            name.text = item.name // Item is of type Cat and is the current bound item.
      }
    }

  sealed class Item {
    class HeroItem(val hero: Hero) : Item()
  }
}
