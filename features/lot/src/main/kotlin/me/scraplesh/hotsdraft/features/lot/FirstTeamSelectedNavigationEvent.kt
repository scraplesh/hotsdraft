package me.scraplesh.hotsdraft.features.lot

import me.scraplesh.hotsdraft.domain.Battleground
import me.scraplesh.hotsdraft.domain.draft.Team
import me.scraplesh.hotsdraft.common.navigation.NavigationEvent

class FirstTeamSelectedNavigationEvent(val team: Team, val battleground: Battleground) : NavigationEvent
