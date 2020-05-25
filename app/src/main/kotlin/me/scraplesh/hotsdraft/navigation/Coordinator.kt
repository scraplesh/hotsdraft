package me.scraplesh.hotsdraft.navigation

import androidx.core.util.Consumer

interface NavigationEvent

interface Coordinator : Consumer<NavigationEvent>
