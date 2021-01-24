package org.rescueme.es.shared.command.infrastructure

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.axonframework.commandhandling.gateway.CommandGateway
import org.rescueme.es.shared.command.domain.Command
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CommandBusAxonTest : Spek({

    val gateway = mockk<CommandGateway>()
    val commandBus = CommandBusAxon(gateway)

    describe("Command bus implementation should dispatch command to Axon gateway") {
        val command = CommandTest("Smoke test")
        describe("Request dispatch") {
            every { gateway.sendAndWait<CommandTest>(command) } returns command
            commandBus.dispatch(command)
            it("Should redirect to Axon gateway") {
                verify(exactly = 1) { gateway.sendAndWait(command) }
            }
        }
    }

})

data class CommandTest(val id: String) : Command