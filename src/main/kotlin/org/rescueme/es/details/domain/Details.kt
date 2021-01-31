package org.rescueme.es.details.domain

import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle.apply
import org.axonframework.spring.stereotype.Aggregate
import org.rescueme.es.details.domain.create.DetailsCreatedEvent
import org.rescueme.es.dog.domain.DogId
import java.time.ZonedDateTime

@Aggregate
class Details {

    @AggregateIdentifier
    private lateinit var detailsId: DetailsId
    private lateinit var dogId: DogId
    private lateinit var dogSpecification: DogSpecification


    companion object {
        fun create(detailsId: DetailsId, dogId: DogId, dogSpecification: DogSpecification) {
            apply(
                DetailsCreatedEvent(
                    aggregateId = detailsId.asString(),
                    occurredOn = ZonedDateTime.now(),
                    dogId = dogId.asString(),
                    dogSpecification = dogSpecification
                )
            )
        }


    }
}