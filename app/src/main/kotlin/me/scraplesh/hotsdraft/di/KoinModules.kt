package me.scraplesh.hotsdraft.di

import me.scraplesh.hotsdraft.features.draft.draftModule
import me.scraplesh.hotsdraft.features.heroes.heroesModule

val koinModules = listOf(
    navigationModule,
    repositoryModule,
    useCasesModule,
    featuresModule,
    draftModule,
    heroesModule
)
