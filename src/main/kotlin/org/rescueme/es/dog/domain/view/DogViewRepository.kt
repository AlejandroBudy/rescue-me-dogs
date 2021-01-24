package org.rescueme.es.dog.domain.view

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.shelter.domain.ShelterId

interface DogViewRepository {
    fun save(dogView: DogView)
    fun find(id: DogId): DogView?
    fun findByShelter(id: ShelterId): DogView?
}