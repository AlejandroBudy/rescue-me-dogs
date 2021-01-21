package org.rescueme.es.dog.domain.view.create

import org.axonframework.eventhandling.EventHandler
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.springframework.stereotype.Component

@Component
class CreateDogViewOnDogCreatedEventHandler(private val creator: DogViewCreator) {

    @EventHandler
    fun on(event: DogCreatedEvent){

    }

}