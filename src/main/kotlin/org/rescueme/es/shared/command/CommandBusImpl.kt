package org.rescueme.es.shared.command

import org.axonframework.commandhandling.gateway.CommandGateway

class CommandBusImpl(private val gateway: CommandGateway) : CommandBus {
    override fun dispatch(command: Command) {
        gateway.sendAndWait<Command>(command)
    }
}