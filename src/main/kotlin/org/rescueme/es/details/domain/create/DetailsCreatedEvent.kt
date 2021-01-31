package org.rescueme.es.details.domain.create

import org.rescueme.es.details.domain.DogSpecification
import org.rescueme.es.shared.domainevent.DomainEvent
import java.time.ZonedDateTime

data class DetailsCreatedEvent(
    val aggregateId: String,
    val occurredOn: ZonedDateTime,
    val dogId: String,
    val dogSpecification: DogSpecification
) : DomainEvent {
    override fun aggregateId() = aggregateId

    override fun occurredOn() = occurredOn
}