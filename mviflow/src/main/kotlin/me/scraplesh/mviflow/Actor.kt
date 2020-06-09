package me.scraplesh.mviflow

import kotlinx.coroutines.flow.Flow

typealias Actor<Action, State, Effect> = (action: Action, state: State) -> Flow<Effect>
