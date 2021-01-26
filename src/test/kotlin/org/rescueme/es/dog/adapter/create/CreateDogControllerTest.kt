package org.rescueme.es.dog.adapter.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.shared.command.domain.CommandBus
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.springframework.http.HttpStatus
import java.util.*
import kotlin.test.assertEquals

object CreateDogControllerTest : Spek({

    val commandBus = mockk<CommandBus>()
    val controller = CreateDogController(commandBus)

    describe("Controller receives dog creation request") {
        val request = CreateDogRequest(name = "Budy", breed = "Bulldog")
        val shelterId = UUID.randomUUID().toString()
        it("Should handle request ok") {
            every { commandBus.dispatch(any()) } returns Unit

            val actual = controller.registerDogInShelter(shelterId, request)

            assertEquals(actual.statusCode, HttpStatus.CREATED, "Status code does not match")

            verify(exactly = 1) { commandBus.dispatch(any()) }
        }
    }

})