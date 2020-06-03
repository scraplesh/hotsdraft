package me.scraplesh.hotsdraft.features.draft

import android.view.View
import android.view.ViewTreeObserver
import android.widget.RadioButton
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import me.scraplesh.domain.Battleground
import me.scraplesh.domain.Hero
import me.scraplesh.hotsdraft.features.draft.databinding.FragmentDraftBinding
import reactivecircus.flowbinding.android.widget.checkedChanges

infix fun <T> List<T>.equalTo(other: List<T>): Boolean =
  size == other.size &&
      mapIndexed { index: Int, item: T -> item == other[index] }
        .all { it }

@FlowPreview
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class DraftView(private val coroutineScope: CoroutineScope) :
  Flow<DraftView.UiEvent>,
  FlowCollector<DraftView.ViewModel> {

  class ViewModel(
    val battleground: Battleground,
    val allUniversesChecked: Boolean,
    val diabloChecked: Boolean,
    val nexusChecked: Boolean,
    val overwatchChecked: Boolean,
    val starcraftChecked: Boolean,
    val warcraftChecked: Boolean,
    val allRolesChecked: Boolean,
    val bruiserChecked: Boolean,
    val healerChecked: Boolean,
    val meleeAssassinChecked: Boolean,
    val rangedAssassinChecked: Boolean,
    val supportChecked: Boolean,
    val tankChecked: Boolean,
    val heroes: List<Hero>,
    val yourPick1: Hero?,
    val yourPick2: Hero?,
    val yourPick3: Hero?,
    val yourPick4: Hero?,
    val yourPick5: Hero?,
    val yourBan1: Hero?,
    val yourBan2: Hero?,
    val yourBan3: Hero?,
    val enemyPick1: Hero?,
    val enemyPick2: Hero?,
    val enemyPick3: Hero?,
    val enemyPick4: Hero?,
    val enemyPick5: Hero?,
    val enemyBan1: Hero?,
    val enemyBan2: Hero?,
    val enemyBan3: Hero?
  )

  sealed class UiEvent {
    class HeroSelected(val hero: Hero) : UiEvent()
    object AllUniversesChecked : UiEvent()
    object DiabloChecked : UiEvent()
    object NexusChecked : UiEvent()
    object OverwatchChecked : UiEvent()
    object StarcraftChecked : UiEvent()
    object WarcraftChecked : UiEvent()
    object AllRolesChecked : UiEvent()
    object BruiserChecked : UiEvent()
    object HealerChecked : UiEvent()
    object MeleeAssassinChecked : UiEvent()
    object RangedAssassinChecked : UiEvent()
    object SupportChecked : UiEvent()
    object TankChecked : UiEvent()
  }

  private val viewModelsChannel = ConflatedBroadcastChannel<ViewModel>()
  private val uiEvents = ConflatedBroadcastChannel<UiEvent>()
  private val viewModels = viewModelsChannel.asFlow()

  private var heroProposalsList by didSet<RecyclerView> {
    layoutManager = GridLayoutManager(context, 5)
    adapter = ListDelegationAdapter(
      heroAdapterDelegate { hero ->
        coroutineScope.launch {
          uiEvents.send(UiEvent.HeroSelected(hero))
        }
      }
    )
      .apply {
        viewModels.map { it.heroes }
          .distinctUntilChanged { old, new -> old equalTo new }
          .onEach { heroes ->
            items = heroes.map { Item.HeroItem(it) }
            notifyDataSetChanged()
          }
          .launchIn(coroutineScope)
      }
  }

  private var yourPick1View by didSet<ImageView> {
    viewModels.map { it.yourPick1 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourPick2View by didSet<ImageView> {
    viewModels.map { it.yourPick2 }
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourPick3View by didSet<ImageView> {
    viewModels.map { it.yourPick3 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourPick4View by didSet<ImageView> {
    viewModels.map { it.yourPick4 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourPick5View by didSet<ImageView> {
    viewModels.map { it.yourPick5 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourBan1View by didSet<ImageView> {
    viewModels.map { it.yourBan1 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourBan2View by didSet<ImageView> {
    viewModels.map { it.yourBan2 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var yourBan3View by didSet<ImageView> {
    viewModels.map { it.yourBan3 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick1View by didSet<ImageView> {
    viewModels.map { it.enemyPick1 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick2View by didSet<ImageView> {
    viewModels.map { it.enemyPick2 }
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick3View by didSet<ImageView> {
    viewModels.map { it.enemyPick3 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick4View by didSet<ImageView> {
    viewModels.map { it.enemyPick4 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick5View by didSet<ImageView> {
    viewModels.map { it.enemyPick5 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var enemyBan1View by didSet<ImageView> {
    viewModels.map { it.enemyBan1 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }

  private var enemyBan2View by didSet<ImageView> {
    coroutineScope.launch {
      viewModels.map { it.enemyBan2 }
        .distinctUntilChanged()
        .onEach { hero ->
          setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
        }
        .launchIn(coroutineScope)
    }
  }
  private var enemyBan3View by didSet<ImageView> {
    viewModels.map { it.enemyBan3 }
      .distinctUntilChanged()
      .onEach { hero ->
        setImageDrawable(hero?.let { ContextCompat.getDrawable(context, hero.drawableId) })
      }
      .launchIn(coroutineScope)
  }
  private var allUniversesRadioButton by didSet<RadioButton> {
    viewModels.map { it.allUniversesChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.AllUniversesChecked) }
      .launchIn(coroutineScope)
  }
  private var diabloCheckBox by didSet<RadioButton> {
    viewModels.map { it.diabloChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.DiabloChecked) }
      .launchIn(coroutineScope)
  }
  private var nexusCheckBox by didSet<RadioButton> {
    viewModels.map { it.nexusChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.NexusChecked) }
      .launchIn(coroutineScope)
  }
  private var overwatchCheckBox by didSet<RadioButton> {
    viewModels.map { it.overwatchChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.OverwatchChecked) }
      .launchIn(coroutineScope)
  }
  private var starcraftCheckBox by didSet<RadioButton> {
    viewModels.map { it.starcraftChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.StarcraftChecked) }
      .launchIn(coroutineScope)
  }
  private var warcraftCheckBox by didSet<RadioButton> {
    viewModels.map { it.warcraftChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.WarcraftChecked) }
      .launchIn(coroutineScope)
  }
  private var allRolesRadioButton by didSet<RadioButton> {
    viewModels.map { it.allRolesChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.AllRolesChecked) }
      .launchIn(coroutineScope)
  }
  private var bruiserRadioButton by didSet<RadioButton> {
    viewModels.map { it.bruiserChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.BruiserChecked) }
      .launchIn(coroutineScope)
  }
  private var healerRadioButton by didSet<RadioButton> {
    viewModels.map { it.healerChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.HealerChecked) }
      .launchIn(coroutineScope)
  }
  private var meleeAssassinRadioButton by didSet<RadioButton> {
    viewModels.map { it.meleeAssassinChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.MeleeAssassinChecked) }
      .launchIn(coroutineScope)
  }
  private var rangedAssassinRadioButton by didSet<RadioButton> {
    viewModels.map { it.rangedAssassinChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.RangedAssassinChecked) }
      .launchIn(coroutineScope)
  }
  private var supportRadioButton by didSet<RadioButton> {
    viewModels.map { it.supportChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.SupportChecked) }
      .launchIn(coroutineScope)
  }
  private var tankRadioButton by didSet<RadioButton> {
    viewModels.map { it.tankChecked }
      .distinctUntilChanged()
      .onEach { isChecked = it }
      .launchIn(coroutineScope)

    checkedChanges().filter { it }
      .onEach { uiEvents.send(UiEvent.TankChecked) }
      .launchIn(coroutineScope)
  }
  private var battlegroundView by didSet<View> {
    coroutineScope.launch {
      viewModels.map {
        ContextCompat.getDrawable(
          context,
          when (it.battleground) {
            Battleground.AlteracPass -> R.drawable.battleground_alterac_pass
            Battleground.BattlefieldOfEternity -> R.drawable.battleground__battlefield_of_eternity
            Battleground.BlackheartsBay -> R.drawable.battleground_blackhearts_bay
            Battleground.BraxisHoldout -> R.drawable.battleground_braxis_holdout
            Battleground.CursedHollow -> R.drawable.battleground_cursed_hollow
            Battleground.DragonShire -> R.drawable.battleground_dragon_shire
            Battleground.GardenOfTerror -> R.drawable.battleground_garden_of_terror
            Battleground.HanamuraTemple -> R.drawable.battleground_hanamura_temple
            Battleground.HauntedMines -> R.drawable.battleground_haunted_mines
            Battleground.InfernalShrines -> R.drawable.battleground_infernal_shrines
            Battleground.SkyTemple -> R.drawable.battleground_sky_temple
            Battleground.TombOfTheSpiderQueen -> R.drawable.battleground_tomb_of_the_spider_queen
            Battleground.TowersOfDoom -> R.drawable.battleground_towers_of_doom
            Battleground.VolskayaFoundry -> R.drawable.battleground_volskaya_foundry
            Battleground.WarheadJunction -> R.drawable.battleground_warhead_junction
          }
        )
      }
        .collect { drawable -> background = drawable }
    }
  }

  fun getView(viewBinding: FragmentDraftBinding): View = viewBinding.apply {
    battlegroundView = constraintlayoutDraftHeroes
    heroProposalsList = recyclerviewDraft
    yourPick1View = imageviewDraftYourTeamHero1
    yourPick2View = imageviewDraftYourTeamHero2
    yourPick3View = imageviewDraftYourTeamHero3
    yourPick4View = imageviewDraftYourTeamHero4
    yourPick5View = imageviewDraftYourTeamHero5
    yourBan1View = imageviewDraftYourTeamBanHero1
    yourBan2View = imageviewDraftYourTeamBanHero2
    yourBan3View = imageviewDraftYourTeamBanHero3
    enemyPick1View = imageviewDraftEnemyTeamHero1
    enemyPick2View = imageviewDraftEnemyTeamHero2
    enemyPick3View = imageviewDraftEnemyTeamHero3
    enemyPick4View = imageviewDraftEnemyTeamHero4
    enemyPick5View = imageviewDraftEnemyTeamHero5
    enemyBan1View = imageviewDraftEnemyTeamBanHero1
    enemyBan2View = imageviewDraftEnemyTeamBanHero2
    enemyBan3View = imageviewDraftEnemyTeamBanHero3
    allUniversesRadioButton = radiobuttonDraftAllUniverses
    diabloCheckBox = radiobuttonDraftDiablo
    nexusCheckBox = radiobuttonDraftNexus
    overwatchCheckBox = radiobuttonDraftOverwatch
    starcraftCheckBox = radiobuttonDraftStarcraft
    warcraftCheckBox = radiobuttonDraftWarcraft
    allRolesRadioButton = radiobuttonDraftAllRoles
    bruiserRadioButton = radiobuttonDraftBruisers
    healerRadioButton = radiobuttonDraftHealers
    meleeAssassinRadioButton = radiobuttonDraftMeleeAssassins
    rangedAssassinRadioButton = radiobuttonDraftRangedAssassins
    supportRadioButton = radiobuttonDraftSupports
    tankRadioButton = radiobuttonDraftTanks

    setupHeroProposalsView(root, constraintlayoutDraftHeroProposals, constraintlayoutDraftHeroes)
  }.root

  private fun setupHeroProposalsView(
    rootView: View,
    heroProposalsView: ConstraintLayout,
    heroDraftView: View
  ) {
    heroProposalsView.viewTreeObserver
      .addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
          val minHeight = rootView.height - heroDraftView.height
          heroProposalsView.minHeight = minHeight
          BottomSheetBehavior.from(heroProposalsView).peekHeight = minHeight

          heroProposalsView.viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
      })
  }

  private fun heroAdapterDelegate(itemClickListener: (Hero) -> Unit) =
    adapterDelegate<Item.HeroItem, Item>(R.layout.item_hero) {
      val heroImage: ImageView = findViewById(R.id.imageview_itemhero)
      heroImage.setOnClickListener { itemClickListener(item.hero) }

      bind {
        heroImage.setImageResource(item.hero.drawableId)
      }
    }

  private val Hero.drawableId
    get() = when (this) {
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

  sealed class Item {
    class HeroItem(val hero: Hero) : Item()
  }

  override suspend fun emit(value: ViewModel) {
    viewModelsChannel.send(value)
  }

  override suspend fun collect(collector: FlowCollector<UiEvent>) {
    uiEvents.asFlow()
      .collect(collector)
  }
}
