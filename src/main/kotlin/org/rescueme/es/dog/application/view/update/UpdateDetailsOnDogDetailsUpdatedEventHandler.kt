package org.rescueme.es.dog.application.view.update

import org.axonframework.eventhandling.EventHandler
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.update.DogDetailsUpdatedEvent
import org.rescueme.es.dog.domain.view.update.DogViewUpdater
import org.springframework.stereotype.Component

@Component
class UpdateDetailsOnDogDetailsUpdatedEventHandler(private val updater: DogViewUpdater) {

    @EventHandler
    fun on(event: DogDetailsUpdatedEvent) {
        updater(
            dogId = DogId.fromString(event.aggregateId),
            dogSpecification = event.dogSpecification,
            updatedAt = event.occurredOn
        )
    }
}