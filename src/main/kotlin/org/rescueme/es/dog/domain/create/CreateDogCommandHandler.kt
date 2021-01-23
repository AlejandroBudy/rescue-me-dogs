package org.rescueme.es.dog.domain.create

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.dog.domain.DogDetails
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component

@Component
open class CreateDogCommandHandler(private val creator: DogCreator) {

    @CommandHandler
    fun on(createDogCommand: CreateDogCommand) {
        creator(
                DogId.fromString(createDogCommand.id),
                ShelterId.fromString(createDogCommand.shelterID),
                DogDetails(createDogCommand.name, createDogCommand.breed)
        )
    }
}