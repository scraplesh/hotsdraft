package me.scraplesh.mviflow

import kotlinx.coroutines.flow.Flow

typealias Actor1<Action, State, Effect> = (action: Action, state: State) -> Flow<Effect>

interface Actor<Action, State, Effect> {
  suspend operator fun invoke(action: Action, state: State): Flow<Effect>
}
