package org.rescueme.es.dog.infrastructure


import org.axonframework.commandhandling.model.AggregateNotFoundException
import org.rescueme.es.dog.domain.Dog
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogRepository
import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Repository
import org.axonframework.commandhandling.model.Repository as AggregateRepository

@Repository
open class AxonDogRepository(private val persistenceRepository: AggregateRepository<Dog>) : DogRepository {
    override fun new(dogId: DogId, shelterId: ShelterId, specification: DogSpecification) {
        persistenceRepository.newInstance {
            Dog.create(dogId, shelterId, specification)
            Dog()
        }
    }

    override fun search(dogId: DogId): Dog? =
        try {
            persistenceRepository.load(dogId.asString()).invoke { it }
        } catch (exception: AggregateNotFoundException) {
            null
        }


}