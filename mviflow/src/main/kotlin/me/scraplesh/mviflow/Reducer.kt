package me.scraplesh.mviflow

typealias Reducer<State, Effect> = (state: State, effect: Effect) -> State
