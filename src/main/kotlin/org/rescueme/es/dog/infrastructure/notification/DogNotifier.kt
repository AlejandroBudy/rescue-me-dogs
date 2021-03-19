package org.rescueme.es.dog.infrastructure.notification

import org.axonframework.eventhandling.EventHandler
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.rescueme.es.dog.domain.update.DogDetailsUpdatedEvent
import org.springframework.stereotype.Repository

@Repository
class DogNotifier {

    @EventHandler
    fun on(dogCreatedEvent: DogCreatedEvent) {

    }

    @EventHandler
    fun on(dogDetailsUpdatedEvent: DogDetailsUpdatedEvent) {

    }
}