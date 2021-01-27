package org.rescueme.es.dog.domain

import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.axonframework.eventhandling.EventHandler
import org.axonframework.spring.stereotype.Aggregate
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.rescueme.es.shelter.domain.ShelterId
import java.time.ZonedDateTime

@Aggregate
class Dog {

    @AggregateIdentifier
    private lateinit var dogId: DogId
    private lateinit var shelterId: ShelterId
    private lateinit var dogInformation: DogInformation

    @EventHandler
    fun onDogCreatedEvent(event: DogCreatedEvent) {
        dogId = event.aggregateId().let { DogId.fromString(it) }
        shelterId = event.shelterId.let { ShelterId.fromString(it) }
        dogInformation = event.dogInformation
    }

    companion object {
        fun create(dogId: DogId, shelterId: ShelterId, dogInformation: DogInformation) {
            apply(
                DogCreatedEvent(
                    aggregateId = dogId.asString(),
                    occurredOn = ZonedDateTime.now(),
                    shelterId = shelterId.asString(),
                    dogInformation = dogInformation
                )
            )
        }
    }
}