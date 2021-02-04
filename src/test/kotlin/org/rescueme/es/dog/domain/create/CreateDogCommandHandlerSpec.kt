package org.rescueme.es.dog.domain.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.*
import org.rescueme.es.dog.application.create.CreateDogCommandHandler
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.shelter.domain.ShelterId

class CreateDogCommandHandlerSpec : Spek({

    val creator = mockk<DogCreator>()
    val handler = CreateDogCommandHandler(creator)

    describe("#${CreateDogCommandHandler::on.name}") {
        val command = createDogCommand()

        on("Create command handler") {
            every {
                creator.invoke(
                    DogId.fromString(dogId),
                    ShelterId.fromString(shelterId),
                    DogInformation(name, breed)
                )
            } returns Unit
            it("Should create dog ok") {
                handler.on(command)
                verify(exactly = 1) { creator.invoke(any()) }
            }
        }


    }
})