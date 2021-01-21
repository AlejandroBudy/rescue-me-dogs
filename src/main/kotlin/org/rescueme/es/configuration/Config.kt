package org.rescueme.es.configuration

import org.axonframework.commandhandling.gateway.CommandGateway
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
class CqrsConfiguration {

    @Bean
    fun commandBus(commandGateway: CommandGateway): CommandBus =
            CommandBusImpl(commandGateway)
}