package me.scraplesh.hotsdraft.features.draft

import android.view.View
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.RadioButton
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
import kotlinx.equalTo
import me.scraplesh.hotsdraft.common.didSet
import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.features.draft.databinding.FragmentDraftBinding
import reactivecircus.flowbinding.android.widget.checkedChanges

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
    val isYourPick1Current: Boolean,
    val isYourPick1Next: Boolean,
    val yourPick2: Hero?,
    val isYourPick2Current: Boolean,
    val isYourPick2Next: Boolean,
    val yourPick3: Hero?,
    val isYourPick3Current: Boolean,
    val isYourPick3Next: Boolean,
    val yourPick4: Hero?,
    val isYourPick4Current: Boolean,
    val isYourPick4Next: Boolean,
    val yourPick5: Hero?,
    val isYourPick5Current: Boolean,
    val isYourPick5Next: Boolean,
    val yourBan1: Hero?,
    val isYourBan1Current: Boolean,
    val isYourBan1Next: Boolean,
    val yourBan2: Hero?,
    val isYourBan2Current: Boolean,
    val isYourBan2Next: Boolean,
    val yourBan3: Hero?,
    val isYourBan3Current: Boolean,
    val isYourBan3Next: Boolean,
    val enemyPick1: Hero?,
    val isEnemyPick1Current: Boolean,
    val isEnemyPick1Next: Boolean,
    val enemyPick2: Hero?,
    val isEnemyPick2Current: Boolean,
    val isEnemyPick2Next: Boolean,
    val enemyPick3: Hero?,
    val isEnemyPick3Current: Boolean,
    val isEnemyPick3Next: Boolean,
    val enemyPick4: Hero?,
    val isEnemyPick4Current: Boolean,
    val isEnemyPick4Next: Boolean,
    val enemyPick5: Hero?,
    val isEnemyPick5Current: Boolean,
    val isEnemyPick5Next: Boolean,
    val enemyBan1: Hero?,
    val isEnemyBan1Current: Boolean,
    val isEnemyBan1Next: Boolean,
    val enemyBan2: Hero?,
    val isEnemyBan2Current: Boolean,
    val isEnemyBan2Next: Boolean,
    val enemyBan3: Hero?,
    val isEnemyBan3Current: Boolean,
    val isEnemyBan3Next: Boolean
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
    viewModels.distinctUntilChanged { old, new ->
      old.yourPick1 == new.yourPick1 &&
          old.isYourPick1Current == new.isYourPick1Current &&
          old.isYourPick1Next == new.isYourPick1Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourPick1 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourPick1.drawableId
            )
            viewModel.isYourPick1Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourPick1Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourPick2View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourPick2 == new.yourPick2 &&
          old.isYourPick2Current == new.isYourPick2Current &&
          old.isYourPick2Next == new.isYourPick2Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourPick2 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourPick2.drawableId
            )
            viewModel.isYourPick2Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourPick2Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourPick3View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourPick3 == new.yourPick3 &&
          old.isYourPick3Current == new.isYourPick3Current &&
          old.isYourPick3Next == new.isYourPick3Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourPick3 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourPick3.drawableId
            )
            viewModel.isYourPick3Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourPick3Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourPick4View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourPick4 == new.yourPick4 &&
          old.isYourPick4Current == new.isYourPick4Current &&
          old.isYourPick4Next == new.isYourPick4Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourPick4 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourPick4.drawableId
            )
            viewModel.isYourPick4Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourPick4Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourPick5View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourPick5 == new.yourPick5 &&
          old.isYourPick5Current == new.isYourPick5Current &&
          old.isYourPick5Next == new.isYourPick5Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourPick5 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourPick5.drawableId
            )
            viewModel.isYourPick5Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourPick5Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourBan1View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourBan1 == new.yourBan1 &&
          old.isYourBan1Current == new.isYourBan1Current &&
          old.isYourBan1Next == new.isYourBan1Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourBan1 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourBan1.drawableId
            )
            viewModel.isYourBan1Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourBan1Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourBan2View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourBan2 == new.yourBan2 &&
          old.isYourBan2Current == new.isYourBan2Current &&
          old.isYourBan2Next == new.isYourBan2Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourBan2 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourBan2.drawableId
            )
            viewModel.isYourBan2Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourBan2Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var yourBan3View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.yourBan3 == new.yourBan3 &&
          old.isYourBan3Current == new.isYourBan3Current &&
          old.isYourBan3Next == new.isYourBan3Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.yourBan3 != null -> ContextCompat.getDrawable(
              context,
              viewModel.yourBan3.drawableId
            )
            viewModel.isYourBan3Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isYourBan3Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick1View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyPick1 == new.enemyPick1 &&
          old.isEnemyPick1Current == new.isEnemyPick1Current &&
          old.isEnemyPick1Next == new.isEnemyPick1Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyPick1 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyPick1.drawableId
            )
            viewModel.isEnemyPick1Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyPick1Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick2View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyPick2 == new.enemyPick2 &&
          old.isEnemyPick2Current == new.isEnemyPick2Current &&
          old.isEnemyPick2Next == new.isEnemyPick2Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyPick2 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyPick2.drawableId
            )
            viewModel.isEnemyPick2Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyPick2Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick3View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyPick3 == new.enemyPick3 &&
          old.isEnemyPick3Current == new.isEnemyPick3Current &&
          old.isEnemyPick3Next == new.isEnemyPick3Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyPick3 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyPick3.drawableId
            )
            viewModel.isEnemyPick3Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyPick3Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick4View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyPick4 == new.enemyPick4 &&
          old.isEnemyPick4Current == new.isEnemyPick4Current &&
          old.isEnemyPick4Next == new.isEnemyPick4Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyPick4 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyPick4.drawableId
            )
            viewModel.isEnemyPick4Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyPick4Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyPick5View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyPick5 == new.enemyPick5 &&
          old.isEnemyPick5Current == new.isEnemyPick5Current &&
          old.isEnemyPick5Next == new.isEnemyPick5Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyPick5 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyPick5.drawableId
            )
            viewModel.isEnemyPick5Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyPick5Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyBan1View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyBan1 == new.enemyBan1 &&
          old.isEnemyBan1Current == new.isEnemyBan1Current &&
          old.isEnemyBan1Next == new.isEnemyBan1Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyBan1 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyBan1.drawableId
            )
            viewModel.isEnemyBan1Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyBan1Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }

  private var enemyBan2View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyBan2 == new.enemyBan2 &&
          old.isEnemyBan2Current == new.isEnemyBan2Current &&
          old.isEnemyBan2Next == new.isEnemyBan2Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyBan2 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyBan2.drawableId
            )
            viewModel.isEnemyBan2Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyBan2Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
      }
      .launchIn(coroutineScope)
  }
  private var enemyBan3View by didSet<ImageView> {
    viewModels.distinctUntilChanged { old, new ->
      old.enemyBan3 == new.enemyBan3 &&
          old.isEnemyBan3Current == new.isEnemyBan3Current &&
          old.isEnemyBan3Next == new.isEnemyBan3Next
    }
      .onEach { viewModel ->
        setImageDrawable(
          when {
            viewModel.enemyBan3 != null -> ContextCompat.getDrawable(
              context,
              viewModel.enemyBan3.drawableId
            )
            viewModel.isEnemyBan3Current -> ContextCompat.getDrawable(
              context,
              R.drawable.green_circle
            )
            viewModel.isEnemyBan3Next -> ContextCompat.getDrawable(
              context,
              R.drawable.yellow_circle
            )
            else -> null
          }
        )
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
