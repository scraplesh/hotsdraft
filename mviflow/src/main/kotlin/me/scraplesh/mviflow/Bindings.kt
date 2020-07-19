package me.scraplesh.mviflow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class Bindings<T>(private val coroutineScope: CoroutineScope) {
  abstract fun setup(view: T)

  protected fun <Out: Any, In: Any> bind(connection: Triple<Flow<Out>, FlowCollector<In>, (Out) -> In?>) {
    val (flow, collector, transformer) = connection
    coroutineScope.launch {
      flow.map { value -> transformer(value) }
        .filterNotNull()
        .collect(collector)
    }
  }

  protected infix fun <Out, In> Pair<Flow<Out>, FlowCollector<In>>.using(transformer: (Out) -> In?) =
    Triple(first, second, transformer)
}
