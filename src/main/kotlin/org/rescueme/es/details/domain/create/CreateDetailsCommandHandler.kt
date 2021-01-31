package org.rescueme.es.details.domain.create

import org.axonframework.commandhandling.CommandHandler
import org.rescueme.es.details.domain.DetailsId
import org.rescueme.es.details.domain.DogSpecification
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.view.find.by_id.FindDogQuery
import org.rescueme.es.shared.query.domain.QueryBus
import org.rescueme.es.shared.query.domain.ask
import org.springframework.stereotype.Component

@Component
class CreateDetailsCommandHandler(private val queryBus: QueryBus, private val creator: DetailsCreator) {

    @CommandHandler
    fun on(createDetailsCommand: CreateDetailsCommand) {

        queryBus.ask<FindDogQuery>(
            FindDogQuery(
                createDetailsCommand.dogId
            )
        ).thenApply {
            creator(
                DetailsId.generate(),
                dogId = DogId.fromString(createDetailsCommand.dogId),
                dogSpecification = DogSpecification.create(
                    birthDate = createDetailsCommand.birthDate,
                    location = createDetailsCommand.location,
                    color = createDetailsCommand.color
                )
            )
        }
    }
}