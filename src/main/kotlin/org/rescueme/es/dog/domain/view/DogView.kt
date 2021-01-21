package org.rescueme.es.dog.domain.view

import org.hibernate.annotations.DynamicUpdate
import org.rescueme.es.dog.domain.DogDetails
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.shelter.domain.ShelterId
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity


@Entity
@DynamicUpdate
data class DogView(@EmbeddedId val id: DogId,
                   @Embedded val shelterId: ShelterId,
                   @Embedded val details: DogDetails,
                   val createdOn: ZonedDateTime) : Serializable