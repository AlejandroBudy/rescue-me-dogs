package org.rescueme.es.shared.command.domain

interface CommandBus {
    fun dispatch(command: Command)
}