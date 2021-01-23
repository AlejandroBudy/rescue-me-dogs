package org.rescueme.es.configuration

import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.model.Repository
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.rescueme.es.dog.domain.Dog
import org.rescueme.es.shared.command.CommandBus
import org.rescueme.es.shared.command.CommandBusImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


fun <R : Any> R.logger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this::class.java.name) }
}

@Configuration
open class CqrsConfiguration {

    @Bean
    open fun customCommandBus(commandGateway: CommandGateway): CommandBus =
            CommandBusImpl(commandGateway)

    @Bean
    open fun dogAggregateRepository(eventStore: EventStore): Repository<Dog> =
            EventSourcingRepository(Dog::class.java, eventStore)

}

