package org.rescueme.es.dog.adapter.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.HttpStatus
import java.util.*
import kotlin.test.assertEquals

object CreateDogControllerSpec : Spek({

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