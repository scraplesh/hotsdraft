package me.scraplesh.hotsdraft.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.hotsdraft.features.heroes.HeroesFeature
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@FlowPreview
@InternalCoroutinesApi
val featuresModule = module {
  factory { HeroesFeature(initialState = HeroesFeature.State(), getHeroesUseCase = get()) }
}
