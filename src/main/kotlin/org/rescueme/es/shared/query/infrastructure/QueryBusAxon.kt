package org.rescueme.es.shared.query.infrastructure

import org.axonframework.queryhandling.QueryGateway
import org.rescueme.es.shared.query.domain.Query
import org.rescueme.es.shared.query.domain.QueryBus
import java.util.concurrent.CompletableFuture
import kotlin.reflect.KClass

class QueryBusAxon(private val gateway: QueryGateway) : QueryBus {
    override fun <T> sendQuery(query: Query, klass: KClass<*>): CompletableFuture<T> {
        @Suppress("UNCHECKED_CAST")
        return gateway.send(query, klass.javaPrimitiveType ?: klass.java)
            .thenApply { it as T }
    }
}