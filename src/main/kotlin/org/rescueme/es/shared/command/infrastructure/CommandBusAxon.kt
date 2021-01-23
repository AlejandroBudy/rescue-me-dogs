package org.rescueme.es.shared.command.infrastructure

import org.axonframework.commandhandling.gateway.CommandGateway
import org.rescueme.es.shared.command.domain.Command
import org.rescueme.es.shared.command.domain.CommandBus

class CommandBusAxon(private val gateway: CommandGateway) : CommandBus {
    override fun dispatch(command: Command) {
        gateway.sendAndWait<Command>(command)
    }
}