package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import me.scraplesh.domain.draft.Draft
import me.scraplesh.domain.heroes.Hero
import me.scraplesh.domain.heroes.Role
import me.scraplesh.domain.heroes.Universe
import me.scraplesh.domain.heroes.filter.HeroesFilter
import me.scraplesh.domain.heroes.filter.NotHeroFilter
import me.scraplesh.domain.heroes.filter.RoleFilter
import me.scraplesh.domain.heroes.filter.UniverseFilter
import me.scraplesh.domain.usecases.FilterHeroesUseCase
import me.scraplesh.domain.usecases.SelectHeroUseCase
import me.scraplesh.domain.usecases.SortHeroesUseCase
import me.scraplesh.mviflow.*

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class DraftFeature(
  coroutineScope: CoroutineScope,
  initialState: State,
  selectHeroUseCase: SelectHeroUseCase,
  sortHeroes: SortHeroesUseCase,
  filterHeroes: FilterHeroesUseCase
) :
  MviFeature<
      DraftFeature.Wish,
      DraftFeature.Action,
      DraftFeature.Effect,
      Nothing,
      DraftFeature.State
      >(
    coroutineScope = coroutineScope,
    initialState = initialState,
    wishToAction = DraftWishToAction(),
    actor = DraftActor(selectHeroUseCase, sortHeroes, filterHeroes),
    reducer = DraftReducer(),
    postProcessor = DraftPostProcessor()
  ) {

  sealed class Wish {
    object UncheckUniverses : Wish()
    object UncheckRoles : Wish()
    class SelectHero(val hero: Hero) : Wish()
    class CheckUniverse(val universe: Universe?) : Wish()
    class CheckRole(val role: Role?) : Wish()
  }

  sealed class Action {
    object FilterHeroes : Action()
    class SelectHero(val hero: Hero) : Action()
    class CheckUniverse(val universe: Universe?) : Action()
    class CheckRole(val role: Role?) : Action()
  }

  data class State(
    val draft: Draft,
    val sortedHeroes: List<Hero> = Hero.values().asList(),
    val filteredHeroes: List<Hero> = sortedHeroes,
    val filters: List<HeroesFilter> = emptyList()
  )

  sealed class Effect {
    class UniverseFilterChanged(val filters: List<HeroesFilter>) : Effect()
    class RoleFilterChanged(val filters: List<HeroesFilter>) : Effect()
    class HeroSelected(
      val draft: Draft,
      val sortedHeroes: List<Hero>,
      val filteredHeroes: List<Hero>,
      val filters: List<HeroesFilter>
    ) : Effect()
    class HeroesFiltered(val heroes: List<Hero>) : Effect()
  }

  class DraftWishToAction : WishToAction<Wish, Action> {
    override fun invoke(wish: Wish): Action = when (wish) {
      is Wish.SelectHero -> Action.SelectHero(wish.hero)
      is Wish.CheckUniverse -> Action.CheckUniverse(wish.universe)
      is Wish.CheckRole -> Action.CheckRole(wish.role)
      Wish.UncheckUniverses -> Action.CheckUniverse(null)
      Wish.UncheckRoles -> Action.CheckRole(null)
    }
  }

  class DraftActor(
    private val selectHeroUseCase: SelectHeroUseCase,
    private val sortHeroes: SortHeroesUseCase,
    private val filterHeroesUseCase: FilterHeroesUseCase
  ) : Actor<Action, State, Effect> {

    override fun invoke(action: Action, state: State): Flow<Effect> {
      return when (action) {
        is Action.SelectHero -> selectHero(action.hero, state.draft, state.filters)
        is Action.CheckUniverse -> checkUniverse(action.universe, state.filters)
        is Action.CheckRole -> checkRole(action.role, state.filters)
        Action.FilterHeroes -> filterHeroes(state.sortedHeroes, state.filters)
      }
    }

    private fun filterHeroes(heroes: List<Hero>, filters: List<HeroesFilter>): Flow<Effect> =
      filterHeroesUseCase(heroes, filters).map { filteredHeroes ->
        Effect.HeroesFiltered(filteredHeroes)
      }

    private fun selectHero(hero: Hero, draft: Draft, filters: List<HeroesFilter>): Flow<Effect> =
      selectHeroUseCase(hero, draft).flatMapConcat { updatedDraft ->
        sortHeroes(updatedDraft).flatMapConcat { sortedHeroes ->
          val newFilters = filters + NotHeroFilter(hero)

          filterHeroesUseCase(sortedHeroes, newFilters).map { filteredHeroes ->
            Effect.HeroSelected(
              draft = updatedDraft,
              sortedHeroes = sortedHeroes,
              filteredHeroes = filteredHeroes,
              filters = newFilters
            )
          }
        }
      }

    private fun checkUniverse(universe: Universe?, filters: List<HeroesFilter>): Flow<Effect> =
      flowOf(
        Effect.UniverseFilterChanged(
          filters.filter { filter -> filter !is UniverseFilter }
            .let { newFilters ->
              if (universe != null) newFilters + UniverseFilter(universe)
              else newFilters
            }
        )
      )

    private fun checkRole(role: Role?, filters: List<HeroesFilter>): Flow<Effect> =
      flowOf(
        Effect.RoleFilterChanged(
          filters.filter { filter -> filter !is RoleFilter }
            .let { newFilters ->
              if (role != null) newFilters + RoleFilter(role)
              else newFilters
            }
        )
      )
  }

  class DraftReducer : Reducer<State, Effect> {
    override fun invoke(state: State, effect: Effect): State = when (effect) {
      is Effect.HeroSelected -> state.copy(
        draft = effect.draft,
        sortedHeroes = effect.sortedHeroes,
        filteredHeroes = effect.filteredHeroes,
        filters = effect.filters
      )
      is Effect.UniverseFilterChanged -> state.copy(filters = effect.filters)
      is Effect.RoleFilterChanged -> state.copy(filters = effect.filters)
      is Effect.HeroesFiltered -> state.copy(filteredHeroes = effect.heroes)
    }
  }

  class DraftPostProcessor :
    PostProcessor<Action, Effect, State> {
    override fun invoke(action: Action, effect: Effect, state: State): Action? {
      return when (effect) {
        is Effect.UniverseFilterChanged -> Action.FilterHeroes
        is Effect.RoleFilterChanged -> Action.FilterHeroes
        else -> null
      }
    }
  }
}

