package org.rescueme.es.dog.domain.view.update

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class DogViewUpdater(private val dogViewRepository: DogViewRepository) {

    operator fun invoke(dogId: DogId, dogSpecification: DogSpecification, updatedAt: ZonedDateTime) {
        dogViewRepository.update(dogId, dogSpecification, updatedAt)
    }
}