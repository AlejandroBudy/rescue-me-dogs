package org.rescueme.es.dog.domain.update

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogNotFoundException
import org.rescueme.es.dog.domain.DogRepository
import org.rescueme.es.dog.domain.DogSpecification
import org.springframework.stereotype.Component

@Component
class DogDetailsUpdater(private val repository: DogRepository) {

    operator fun invoke(dogId: DogId, dogSpecification: DogSpecification) {
        repository.search(dogId)
            .also { it ?: throw DogNotFoundException("Dog with id $dogId not found") }!!
            .updateDetails(dogSpecification)

    }
}