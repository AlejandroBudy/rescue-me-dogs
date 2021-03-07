package org.rescueme.es.dog.domain.view

import org.hibernate.annotations.DynamicUpdate
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.shared.noargs.NoArgsConstructor
import org.rescueme.es.shelter.domain.ShelterId
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity


@Entity
@DynamicUpdate
@NoArgsConstructor
data class DogView(
    @EmbeddedId val id: DogId,
    @Embedded val shelterId: ShelterId,
    @Embedded val information: DogInformation,
    val createdOn: ZonedDateTime
) : Serializable