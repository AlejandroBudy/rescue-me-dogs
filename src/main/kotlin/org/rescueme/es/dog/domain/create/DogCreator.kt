package org.rescueme.es.dog.domain.create

import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component

@Component
class DogCreator(private val dogRepository: DogRepository) {
    operator fun invoke(dogId: DogId, shelterId: ShelterId, dogInformation: DogInformation) {
        dogRepository.new(dogId, shelterId, dogInformation)
    }
}