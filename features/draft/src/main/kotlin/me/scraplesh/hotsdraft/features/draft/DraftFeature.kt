package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import me.scraplesh.hotsdraft.domain.draft.Draft
import me.scraplesh.hotsdraft.domain.heroes.Hero
import me.scraplesh.hotsdraft.domain.heroes.Role
import me.scraplesh.hotsdraft.domain.heroes.Universe
import me.scraplesh.hotsdraft.domain.heroes.filter.HeroesFilter
import me.scraplesh.hotsdraft.domain.heroes.filter.NotHeroFilter
import me.scraplesh.hotsdraft.domain.heroes.filter.RoleFilter
import me.scraplesh.hotsdraft.domain.heroes.filter.UniverseFilter
import me.scraplesh.hotsdraft.domain.heroes.sorter.HeroesSorter
import me.scraplesh.hotsdraft.domain.usecases.AnalyzedDraftUseCase
import me.scraplesh.hotsdraft.domain.usecases.FilterHeroesUseCase
import me.scraplesh.hotsdraft.domain.usecases.SelectHeroUseCase
import me.scraplesh.hotsdraft.domain.usecases.SortHeroesUseCase
import me.scraplesh.mviflow.*

class DraftFeature(
  initialState: State,
  selectHeroUseCase: SelectHeroUseCase,
  sortHeroesUseCase: SortHeroesUseCase,
  filterHeroesUseCase: FilterHeroesUseCase,
  analyzeDraftUseCase: AnalyzedDraftUseCase
) :
  MviFeature<
      DraftFeature.Wish,
      DraftFeature.Action,
      DraftFeature.Effect,
      Nothing,
      DraftFeature.State
      >(
    initialState = initialState,
    wishToAction = DraftWishToAction(),
    bootstrapper = DraftBootstrapper(),
    actor = DraftActor(
      selectHeroUseCase = selectHeroUseCase,
      sortHeroesUseCase = sortHeroesUseCase,
      filterHeroesUseCase = filterHeroesUseCase,
      analyzeDraftUseCase = analyzeDraftUseCase
    ),
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
    object InitialSortHeroes : Action()
    class SelectHero(val hero: Hero) : Action()
    class CheckUniverse(val universe: Universe?) : Action()
    class CheckRole(val role: Role?) : Action()
  }

  data class State(
    val draft: Draft,
    val filters: List<HeroesFilter> = emptyList(),
    val sortedHeroes: List<Hero> = emptyList(),
    val filteredHeroes: List<Hero> = emptyList()
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
    class HeroesSorted(val heroes: List<Hero>) : Effect()
    class AnalyzedDraft(val sorters: List<HeroesSorter>) : Effect()
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

  class DraftBootstrapper : Bootstrapper<Action> {
    override fun invoke(): Flow<Action> = flowOf(Action.InitialSortHeroes)
  }

  class DraftActor(
    private val selectHeroUseCase: SelectHeroUseCase,
    private val sortHeroesUseCase: SortHeroesUseCase,
    private val filterHeroesUseCase: FilterHeroesUseCase,
    private val analyzeDraftUseCase: AnalyzedDraftUseCase
  ) : Actor<Action, State, Effect> {

    override suspend fun invoke(action: Action, state: State): Flow<Effect> {
      return when (action) {
        is Action.SelectHero -> selectHero(
          action.hero,
          state.draft,
          state.filters
        )
        is Action.CheckUniverse -> checkUniverse(action.universe, state.filters)
        is Action.CheckRole -> checkRole(action.role, state.filters)
        Action.FilterHeroes -> filterHeroes(state.filters)
        Action.InitialSortHeroes -> initialSortHeroes(state.draft)
      }
    }

    private fun initialSortHeroes(draft: Draft): Flow<Effect> =
      analyzeDraft(draft).flatMapConcat { analyzedDraftEffect ->
        val newSorters = (analyzedDraftEffect as Effect.AnalyzedDraft).sorters
        sortHeroes(Hero.values().asList(), newSorters)
      }

    private fun filterHeroes(filters: List<HeroesFilter>): Flow<Effect> =
      filterHeroesUseCase(Hero.values().asList(), filters).map { filteredHeroes ->
        Effect.HeroesFiltered(filteredHeroes)
      }

    private fun selectHero(hero: Hero, draft: Draft, filters: List<HeroesFilter>): Flow<Effect> =
      selectHeroUseCase(hero, draft).flatMapConcat { updatedDraft ->
        val newFilters = filters + NotHeroFilter(hero)

        filterHeroes(newFilters).flatMapConcat { filteredHeroesEffect ->
          val filteredHeroes = (filteredHeroesEffect as Effect.HeroesFiltered).heroes

          analyzeDraft(updatedDraft).flatMapConcat { analyzedDraftEffect ->
            val newSorters = (analyzedDraftEffect as Effect.AnalyzedDraft).sorters

            sortHeroes(filteredHeroes, newSorters).map { sortedHeroesEffect ->
              val sortedHeroes = (sortedHeroesEffect as Effect.HeroesSorted).heroes

              Effect.HeroSelected(
                draft = updatedDraft,
                sortedHeroes = sortedHeroes,
                filteredHeroes = filteredHeroes,
                filters = newFilters
              )
            }
          }
        }
      }

    private fun analyzeDraft(draft: Draft): Flow<Effect> =
      analyzeDraftUseCase(draft).map { newSorters -> Effect.AnalyzedDraft(newSorters) }

    private fun sortHeroes(heroes: List<Hero>, sorters: List<HeroesSorter>): Flow<Effect> =
      sortHeroesUseCase(heroes, sorters).map { sortedHeroes -> Effect.HeroesSorted(sortedHeroes) }

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
      is Effect.HeroesSorted -> state.copy(
        sortedHeroes = effect.heroes,
        filteredHeroes = effect.heroes
      )
      is Effect.AnalyzedDraft -> state
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

