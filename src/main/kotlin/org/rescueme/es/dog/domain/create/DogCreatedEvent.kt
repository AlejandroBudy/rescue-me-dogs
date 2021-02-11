package org.rescueme.es.dog.domain.create

import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.shared.domainevent.DomainEvent
import java.time.ZonedDateTime

data class DogCreatedEvent(
    val aggregateId: String,
    val occurredOn: ZonedDateTime,
    val shelterId: String,
    val dogSpecification: DogSpecification
) : DomainEvent {
    override fun aggregateId() = aggregateId

    override fun occurredOn() = occurredOn
}