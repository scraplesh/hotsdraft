package me.scraplesh.hotsdraft.di

import me.scraplesh.hotsdraft.data.repo.HeroesGateway
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val repositoryModule = module {
  factory<HeroesRepository> {
    HeroesGateway(offSiteParser = get { parametersOf(androidContext()) })
  }
}
