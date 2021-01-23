package org.rescueme.es.dog.domain.view

import org.rescueme.es.dog.domain.DogId

interface DogViewRepository {
    fun save(dogView: DogView)
    fun find(id: DogId): DogView?
}