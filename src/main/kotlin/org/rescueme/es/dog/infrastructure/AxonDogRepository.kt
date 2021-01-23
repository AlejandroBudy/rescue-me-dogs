package org.rescueme.es.dog.infrastructure

import org.rescueme.es.dog.domain.Dog
import org.rescueme.es.dog.domain.DogDetails
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.create.DogRepository
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Repository
import org.axonframework.commandhandling.model.Repository as AggregateRepository

@Repository
open class AxonDogRepository(private val persistenceRepository: AggregateRepository<Dog>) : DogRepository {
    override fun new(dogId: DogId, shelterId: ShelterId, details: DogDetails) {
        persistenceRepository.newInstance {
            Dog.create(dogId, shelterId, details)
            Dog()
        }
    }
}