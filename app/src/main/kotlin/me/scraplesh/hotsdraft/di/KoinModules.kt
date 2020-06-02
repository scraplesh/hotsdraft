package me.scraplesh.hotsdraft.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import me.scraplesh.hotsdraft.features.draft.draftModule

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val koinModules = listOf(
    navigationModule,
    draftModule
)
