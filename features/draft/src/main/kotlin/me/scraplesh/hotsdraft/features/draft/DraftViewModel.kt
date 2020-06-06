package me.scraplesh.hotsdraft.features.draft

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import me.scraplesh.domain.Hero
import me.scraplesh.domain.Role
import me.scraplesh.domain.Universe
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.usecases.SortHeroesUseCase
import me.scraplesh.domain.usecases.SelectHeroUseCase

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftViewModel(
  initialState: State,
  private val selectHeroUseCase: SelectHeroUseCase,
  private val sortHeroes: SortHeroesUseCase
) :
  ViewModel(),
  FlowCollector<DraftViewModel.Wish>,
  Flow<DraftViewModel.State> {

  private val states = ConflatedBroadcastChannel(initialState)
  private val wishes = ConflatedBroadcastChannel<Wish>()

  init {
    wishes.asFlow()
      .flatMapConcat { wish -> act(wish, states.value) }
      .map { effect -> reduce(states.value, effect) }
      .onEach { state -> states.send(state) }
      .launchIn(viewModelScope)
  }

  sealed class Wish {
    class SelectHero(val hero: Hero) : Wish()
    object CheckAllUniverses : Wish()
    object CheckDiablo : Wish()
    object CheckNexus : Wish()
    object CheckOverwatch : Wish()
    object CheckStarcraft : Wish()
    object CheckWarcraft : Wish()
    object CheckAllRoles : Wish()
    object CheckBruiser : Wish()
    object CheckHealer : Wish()
    object CheckMeleeAssassin : Wish()
    object CheckRangedAssassin : Wish()
    object CheckSupport : Wish()
    object CheckTank : Wish()
  }

  data class State(
    val draft: Draft,
    val selectedUniverse: Universe? = null,
    val selectedRole: Role? = null,
    val proposedHeroes: List<Hero> = Hero.values().asList(),
    val filteredHeroes: List<Hero> = proposedHeroes
  )

  sealed class Effect {
    class UniverseChecked(val universe: Universe?, val filteredHeroes: List<Hero>) : Effect()
    class RoleChecked(val role: Role?, val filteredHeroes: List<Hero>) : Effect()
    class HeroSelected(
      val draft: Draft,
      val proposedHeroes: List<Hero>,
      val filteredHeroes: List<Hero>
    ) : Effect()
  }

  override suspend fun collect(collector: FlowCollector<State>) {
    states.asFlow()
      .collect(collector)
  }

  override suspend fun emit(value: Wish) {
    wishes.send(value)
  }

  private fun act(wish: Wish, state: State): Flow<Effect> {
    fun selectHero(hero: Hero, draft: Draft): Flow<Effect> =
      selectHeroUseCase(hero, draft).flatMapConcat { updatedDraft ->
        sortHeroes(updatedDraft)

        Effect.HeroSelected(
          draft = updatedDraft,
          proposedHeroes = state.proposedHeroes.filter { it != hero },
          filteredHeroes = state.filteredHeroes.filter { it != hero }
        )
      }

    fun checkUniverse(
      universe: Universe?,
      proposedHeroes: List<Hero>,
      selectedRole: Role?
    ): Flow<Effect> = flowOf(
      Effect.UniverseChecked(
        universe,
        proposedHeroes.filter { hero ->
          selectedRole?.let { hero.role == selectedRole } ?: true &&
              universe?.let { hero.universe == universe } ?: true
        }
      )
    )

    fun checkRole(
      role: Role?,
      proposedHeroes: List<Hero>,
      selectedUniverse: Universe?
    ): Flow<Effect> = flowOf(
      Effect.RoleChecked(
        role,
        proposedHeroes.filter { hero ->
          selectedUniverse?.let { hero.universe == selectedUniverse } ?: true &&
              role?.let { hero.role == role } ?: true
        }
      )
    )

    return when (wish) {
      is Wish.SelectHero -> selectHero(wish.hero, state.draft)
      Wish.CheckAllUniverses -> checkUniverse(null, state.proposedHeroes, state.selectedRole)
      Wish.CheckDiablo -> checkUniverse(Universe.Diablo, state.proposedHeroes, state.selectedRole)
      Wish.CheckNexus -> checkUniverse(Universe.Nexus, state.proposedHeroes, state.selectedRole)
      Wish.CheckOverwatch -> checkUniverse(
        Universe.Overwatch,
        state.proposedHeroes,
        state.selectedRole
      )
      Wish.CheckStarcraft -> checkUniverse(
        Universe.Starcraft,
        state.proposedHeroes,
        state.selectedRole
      )
      Wish.CheckWarcraft -> checkUniverse(
        Universe.Warcraft,
        state.proposedHeroes,
        state.selectedRole
      )
      Wish.CheckAllRoles -> checkRole(null, state.proposedHeroes, state.selectedUniverse)
      Wish.CheckBruiser -> checkRole(Role.Bruiser, state.proposedHeroes, state.selectedUniverse)
      Wish.CheckHealer -> checkRole(Role.Healer, state.proposedHeroes, state.selectedUniverse)
      Wish.CheckMeleeAssassin -> checkRole(
        Role.MeleeAssassin,
        state.proposedHeroes,
        state.selectedUniverse
      )
      Wish.CheckRangedAssassin -> checkRole(
        Role.RangedAssassin,
        state.proposedHeroes,
        state.selectedUniverse
      )
      Wish.CheckSupport -> checkRole(Role.Support, state.proposedHeroes, state.selectedUniverse)
      Wish.CheckTank -> checkRole(Role.Tank, state.proposedHeroes, state.selectedUniverse)
    }
  }

  private fun reduce(state: State, effect: Effect): State = when (effect) {
    is Effect.HeroSelected -> state.copy(
      draft = effect.draft,
      proposedHeroes = effect.proposedHeroes,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.UniverseChecked -> state.copy(
      selectedUniverse = effect.universe,
      filteredHeroes = effect.filteredHeroes
    )
    is Effect.RoleChecked -> state.copy(
      selectedRole = effect.role,
      filteredHeroes = effect.filteredHeroes
    )
  }
}
