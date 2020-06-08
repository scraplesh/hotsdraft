package me.scraplesh.hotsdraft.features.draft

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.Role
import me.scraplesh.domain.heroes.Universe
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.usecases.FilterHeroesUseCase
import me.scraplesh.domain.usecases.SortHeroesUseCase
import me.scraplesh.domain.usecases.SelectHeroUseCase

typealias HeroesSorter = (heroes: List<Hero>) -> List<Hero>
typealias HeroesFilter = (heroes: List<Hero>) -> List<Hero>

class UniverseFilter(private val universe: Universe?) : HeroesFilter {
  override fun invoke(heroes: List<Hero>): List<Hero> =
    heroes.filter { hero -> universe?.let { hero.universe == it } ?: true }
}

class RoleFilter(private val role: Role?) : HeroesFilter {
  override fun invoke(heroes: List<Hero>): List<Hero> =
    heroes.filter { hero -> role?.let { hero.role == it } ?: true }
}

class AlphabetSorter(private val getName: (Hero) -> String) : HeroesSorter {
  override fun invoke(heroes: List<Hero>): List<Hero> = heroes.sortedByDescending(getName)
}

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftViewModel(
  initialState: State,
  private val selectHeroUseCase: SelectHeroUseCase,
  private val sortHeroes: SortHeroesUseCase,
  private val filterHeroes: FilterHeroesUseCase
) :
  ViewModel(),
  FlowCollector<DraftViewModel.Wish>,
  Flow<DraftViewModel.State> {

  private val wishes = ConflatedBroadcastChannel<Wish>()
  private val states = ConflatedBroadcastChannel(initialState)

  init {
    wishes.asFlow()
      .flatMapConcat { wish -> act(wish, states.value).map { effect -> wish to effect } }
      .map { (wish, effect) -> Triple(wish, effect, reduce(states.value, effect)) }
      .onEach { (wish, effect, state) ->
        postProcess(wish, effect, state)?.let { wishes.send(it) }
        states.send(state)
      }
      .launchIn(viewModelScope)
  }

  sealed class Wish {
    class SelectHero(val hero: Hero) : Wish()
    class CheckUniverse(val universe: Universe?) : Wish()
    class CheckRole(val role: Role?) : Wish()
  }

  data class State(
      val draft: Draft,
      val heroes: List<Hero> = Hero.values().asList(),
      val sorters: List<HeroesSorter> = emptyList(),
      val filters: List<HeroesFilter> = emptyList()
  )

  sealed class Effect {
    class UniverseChecked(val universe: Universe?) : Effect()
    class RoleChecked(val role: Role?) : Effect()
    class HeroSelected(val draft: Draft, val heroes: List<Hero>) : Effect()
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
        sortHeroes(updatedDraft).flatMapConcat { sortedHeroes ->
          filterHeroes(sortedHeroes)
        }
          .map { filteredHeroes ->
            Effect.HeroSelected(
              draft = updatedDraft,
              heroes = filteredHeroes
            )
          }
      }

    fun checkUniverse(universe: Universe?): Flow<Effect> = flowOf(Effect.UniverseChecked(universe))
    fun checkRole(role: Role?, heroes: List<Hero>): Flow<Effect> = flowOf(Effect.RoleChecked(role))

    return when (wish) {
      is Wish.SelectHero -> selectHero(wish.hero, state.draft)
      is Wish.CheckUniverse -> checkUniverse(universe = wish.universe, heroes = state.heroes)
      is Wish.CheckRole -> checkRole(state.heroes, role = wish.role)
    }
  }

  private fun reduce(state: State, effect: Effect): State = when (effect) {
    is Effect.HeroSelected -> state.copy(draft = effect.draft, heroes = effect.heroes)
    is Effect.UniverseChecked -> state
    is Effect.RoleChecked -> state
  }

  private fun postProcess(wish: Wish, effect: Effect, state: State): Wish? {
    return when (effect) {
      is Effect.UniverseChecked -> TODO()
      is Effect.RoleChecked -> TODO()
      else -> null
    }
  }
}
