package me.scraplesh.hotsdraft.di

import me.scraplesh.hotsdraft.features.heroes.HeroesFeature
import org.koin.dsl.module

val featuresModule = module {
  factory { HeroesFeature(initialState = HeroesFeature.State(), getHeroesUseCase = get()) }
}
