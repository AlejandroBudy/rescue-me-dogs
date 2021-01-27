package org.rescueme.es.configuration

import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.model.Repository
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.queryhandling.QueryGateway
import org.rescueme.es.dog.domain.Dog
import org.rescueme.es.shared.command.domain.CommandBus
import org.rescueme.es.shared.command.infrastructure.CommandBusAxon
import org.rescueme.es.shared.query.domain.QueryBus
import org.rescueme.es.shared.query.infrastructure.QueryBusAxon
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class CqrsConfiguration {

    @Bean
    open fun customCommandBus(commandGateway: CommandGateway): CommandBus =
        CommandBusAxon(commandGateway)

    @Bean
    open fun customQueryBus(queryGateway: QueryGateway): QueryBus =
        QueryBusAxon(queryGateway)

    @Bean
    open fun dogAggregateRepository(eventStore: EventStore): Repository<Dog> =
        EventSourcingRepository(Dog::class.java, eventStore)

}

