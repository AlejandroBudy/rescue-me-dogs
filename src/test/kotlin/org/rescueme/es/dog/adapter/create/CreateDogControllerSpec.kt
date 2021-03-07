package org.rescueme.es.dog.adapter.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.createDogRequest
import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.HttpStatus
import java.util.*
import kotlin.test.assertEquals

class CreateDogControllerSpec : Spek({

    val commandBus = mockk<CommandBus>()
    val controller = CreateDogController(commandBus)
    describe("#${CreateDogController::registerDogInShelter.name}") {
        on("Controller receives dog creation request") {
            val request = createDogRequest()
            val shelterId = UUID.randomUUID().toString()
            it("Should handle request ok") {
                every { commandBus.dispatch(any()) } returns Unit

                val actual = controller.registerDogInShelter(request)

                assertEquals(actual.statusCode, HttpStatus.CREATED, "Status code does not match")

                verify(exactly = 1) { commandBus.dispatch(any()) }
            }
        }
    }


})