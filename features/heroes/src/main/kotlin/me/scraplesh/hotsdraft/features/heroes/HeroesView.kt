package me.scraplesh.hotsdraft.features.heroes

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import kotlinx.equalTo
import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.features.heroes.databinding.FragmentHeroesBinding
import reactivecircus.flowbinding.android.widget.checkedChanges

@FlowPreview
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class HeroesView(private val coroutineScope: CoroutineScope) :
  Flow<HeroesView.UiEvent>,
  FlowCollector<HeroesView.ViewModel>,
  DefaultLifecycleObserver {

  class ViewModel(
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
    val heroes: List<Hero>
  )

  sealed class UiEvent {
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
    object Created : UiEvent()
  }

  private val viewModelsChannel = ConflatedBroadcastChannel<ViewModel>()
  private val uiEvents = ConflatedBroadcastChannel<UiEvent>()
  private val viewModels = viewModelsChannel.asFlow()

  private var heroProposalsList by didSet<RecyclerView> {
    layoutManager = GridLayoutManager(context, 5)
    adapter = ListDelegationAdapter(
      adapterDelegate<Item.HeroItem, Item>(R.layout.item_hero) {
        val heroImage: ImageView = findViewById(R.id.imageview_itemhero)
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

  @SuppressLint("SetJavaScriptEnabled")
  fun getView(viewBinding: FragmentHeroesBinding): View = viewBinding.apply {
    heroProposalsList = recyclerviewDraft
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
  }.root

  override fun onCreate(owner: LifecycleOwner) {
    flowOf(UiEvent.Created).onEach { event -> uiEvents.send(event) }
      .launchIn(coroutineScope)
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
