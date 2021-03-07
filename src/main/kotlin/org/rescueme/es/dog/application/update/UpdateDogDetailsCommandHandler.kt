package org.rescueme.es.dog.application.update

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.dog.domain.update.DogDetailsUpdater
import org.rescueme.es.dog.domain.view.DogResponse
import org.rescueme.es.dog.domain.view.find.by_id.FindDogQuery
import org.rescueme.es.shared.query.domain.QueryBus
import org.rescueme.es.shared.query.domain.ask
import org.springframework.stereotype.Component

@Component
open class UpdateDogDetailsCommandHandler(private val queryBus: QueryBus, private val updater: DogDetailsUpdater) {

    @CommandHandler
    fun on(updateDogDetailsCommand: UpdateDogDetailsCommand) {

        queryBus.ask<DogResponse>(
            FindDogQuery(
                updateDogDetailsCommand.dogId
            )
        ).thenApply {
            updater(
                dogId = DogId.fromString(updateDogDetailsCommand.dogId),
                dogSpecification =
                DogSpecification.create(
                    birthDate = updateDogDetailsCommand.dogDetails.birthDate,
                    location = updateDogDetailsCommand.dogDetails.location,
                    color = updateDogDetailsCommand.dogDetails.color,
                    name = updateDogDetailsCommand.dogDetails.name,
                    breed = updateDogDetailsCommand.dogDetails.breed
                )
            )
        }.exceptionally { println("No dogs found for id ${updateDogDetailsCommand.dogId}, $it") }
    }
}