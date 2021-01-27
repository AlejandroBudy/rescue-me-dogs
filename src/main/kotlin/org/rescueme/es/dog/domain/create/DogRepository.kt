package org.rescueme.es.dog.domain.create

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.shelter.domain.ShelterId

interface DogRepository {
    fun new(dogId: DogId, shelterId: ShelterId, information: DogInformation)
}