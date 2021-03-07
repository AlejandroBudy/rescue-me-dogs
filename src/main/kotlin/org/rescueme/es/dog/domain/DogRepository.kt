package org.rescueme.es.dog.domain

import org.rescueme.es.shelter.domain.ShelterId

interface DogRepository {
    fun new(dogId: DogId, shelterId: ShelterId, specification: DogSpecification)
    fun search(dogId: DogId): Dog?
}