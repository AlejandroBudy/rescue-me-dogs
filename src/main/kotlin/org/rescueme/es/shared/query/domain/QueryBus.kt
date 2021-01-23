package org.rescueme.es.shared.query.domain

import java.util.concurrent.CompletableFuture
import kotlin.reflect.KClass

interface QueryBus {
    fun <T> sendQuery(query: Query, klass: KClass<*>): CompletableFuture<T>
}

inline fun <reified T> QueryBus.ask(query: Query): CompletableFuture<T> {
    return this.sendQuery(query, T::class)
}