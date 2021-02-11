package org.rescueme.es.dog.domain.update

import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.shared.domainevent.DomainEvent
import java.time.ZonedDateTime

data class DogDetailsUpdatedEvent(
    val aggregateId: String,
    val occurredOn: ZonedDateTime,
    val dogSpecification: DogSpecification
) : DomainEvent {
    override fun aggregateId() = aggregateId

    override fun occurredOn() = occurredOn
}