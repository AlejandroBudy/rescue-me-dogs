package org.rescueme.es.dog.application.create

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.dog.domain.create.DogCreator
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component

@Component
open class CreateDogCommandHandler(private val creator: DogCreator) {

    @CommandHandler
    fun on(createDogCommand: CreateDogCommand) {
        creator(
            DogId.fromString(createDogCommand.id),
            ShelterId.fromString(createDogCommand.shelterID),
            DogSpecification.create(
                birthDate = createDogCommand.dogDetails.birthDate,
                location = createDogCommand.dogDetails.location,
                color = createDogCommand.dogDetails.color,
                name = createDogCommand.dogDetails.name,
                breed = createDogCommand.dogDetails.breed
            )
        )
    }
}