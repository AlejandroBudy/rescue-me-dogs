package org.rescueme.es.dog.domain.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.*
import org.rescueme.es.dog.application.view.create.CreateDogViewOnDogCreatedEventHandler
import org.rescueme.es.dog.domain.view.create.DogViewCreator

class CreateDogViewOnDogCreatedEventHandlerSpec : Spek({

    val creator = mockk<DogViewCreator>()
    val eventHandler = CreateDogViewOnDogCreatedEventHandler(creator)

    describe("#${CreateDogViewOnDogCreatedEventHandler::on.name}") {
        on("Dog created Event") {
            every { creator.invoke(dogIdVO, shelterIdVO, createDogSpecification(), dateTime) } returns Unit
            it("Should invoke creator ok") {
                eventHandler.on(createDogCreatedEvent())
                verify(exactly = 1) { creator.invoke(dogIdVO, shelterIdVO, createDogSpecification(), dateTime) }
            }
        }
    }
})