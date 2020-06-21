package me.scraplesh.hotsdraft.di

import android.content.Context
import me.scraplesh.hotsdraft.data.HeroesHearthHeroesRepository
import me.scraplesh.hotsdraft.domain.repo.HeroesRepository
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val repositoryModule = module {
  factory<HeroesRepository> { (context: Context) ->
    HeroesHearthHeroesRepository(crawler = get { parametersOf(context) })
  }
}
