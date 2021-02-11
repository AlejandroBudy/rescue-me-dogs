package org.rescueme.es.dog.domain.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.application.create.CreateDogCommandHandler
import org.rescueme.es.dog.createDogCommand
import org.rescueme.es.dog.createDogSpecification
import org.rescueme.es.dog.dogIdVO
import org.rescueme.es.dog.shelterIdVO

class CreateDogCommandHandlerSpec : Spek({

    val creator = mockk<DogCreator>()
    val handler = CreateDogCommandHandler(creator)

    describe("#${CreateDogCommandHandler::on.name}") {
        val command = createDogCommand()

        on("Create command handler") {
            every {
                creator.invoke(
                    dogIdVO,
                    shelterIdVO,
                    createDogSpecification()
                )
            } returns Unit
            it("Should create dog ok") {
                handler.on(command)
                verify(exactly = 1) { creator.invoke(any()) }
            }
        }


    }
})