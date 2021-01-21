package org.rescueme.es.dog.domain.view.create

import org.rescueme.es.dog.domain.DogDetails
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.shelter.domain.ShelterId
import java.time.ZonedDateTime

class DogViewCreator {

    operator fun invoke(dogId: DogId, shelterId: ShelterId, dogDetails: DogDetails, createdAt: ZonedDateTime) {

    }
}