package me.scraplesh.hotsdraft.features.draft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@InternalCoroutinesApi
abstract class AndroidBindings<T>(private val coroutineScope: CoroutineScope) {
  abstract fun setup(view: T)

  protected fun <Out: Any, In: Any> bind(connection: Triple<Flow<Out>, FlowCollector<In>, (Out) -> In?>) {
    val (flow, collector, transformer) = connection
    coroutineScope.launch {
      flow.map { value -> transformer(value) }
        .filterNotNull()
        .catch {  }
        .collect(collector)
    }
  }
}

infix fun <Out, In> Pair<Flow<Out>, FlowCollector<In>>.using(transformer: (Out) -> In?) =
  Triple(first, second, transformer)
