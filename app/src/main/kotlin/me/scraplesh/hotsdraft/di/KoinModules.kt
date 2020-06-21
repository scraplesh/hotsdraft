package me.scraplesh.hotsdraft.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.hotsdraft.features.draft.draftModule
import me.scraplesh.hotsdraft.features.heroes.heroesModule

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val koinModules = listOf(
    navigationModule,
    repositoryModule,
    useCasesModule,
    featuresModule,
    draftModule,
    heroesModule
)
