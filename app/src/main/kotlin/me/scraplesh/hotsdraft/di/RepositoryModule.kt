package me.scraplesh.hotsdraft.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import me.scraplesh.hotsdraft.data.OfficialSiteHeroesRepository
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val repositoryModule = module {
  factory<HeroesRepository> {
    OfficialSiteHeroesRepository(crawler = get { parametersOf(androidContext()) })
  }
}
