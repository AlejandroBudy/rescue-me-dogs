package org.rescueme.es.dog.domain.create

import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.shared.domainevent.DomainEvent
import java.time.ZonedDateTime

data class DogCreatedEvent(
        val aggregateId: String,
        val occurredOn: ZonedDateTime,
        val shelterId: String,
        val dogInformation: DogInformation) : DomainEvent {
    override fun aggregateId() = aggregateId

    override fun occurredOn() = occurredOn
}