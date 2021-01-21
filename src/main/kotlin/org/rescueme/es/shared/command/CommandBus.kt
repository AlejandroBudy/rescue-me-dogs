package org.rescueme.es.shared.command

interface CommandBus {
    fun dispatch(command: Command)
}