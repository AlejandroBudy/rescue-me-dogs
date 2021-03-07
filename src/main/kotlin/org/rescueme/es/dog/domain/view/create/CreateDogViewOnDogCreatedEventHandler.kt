package org.rescueme.es.dog.domain.view.create

import org.axonframework.eventhandling.EventHandler
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component

@Component
class CreateDogViewOnDogCreatedEventHandler(private val creator: DogViewCreator) {

    @EventHandler
    fun on(event: DogCreatedEvent) {
        creator(
            DogId.fromString(event.aggregateId),
            ShelterId.fromString(event.shelterId),
            event.dogInformation,
            event.occurredOn
        )
    }

}