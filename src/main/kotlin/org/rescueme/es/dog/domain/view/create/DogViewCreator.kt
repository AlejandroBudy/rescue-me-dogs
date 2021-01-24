package org.rescueme.es.dog.domain.view.create

import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.view.DogView
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
class DogViewCreator(private val dogViewRepository: DogViewRepository) {

    operator fun invoke(dogId: DogId, shelterId: ShelterId, dogInformation: DogInformation, createdAt: ZonedDateTime) {
        DogView(dogId, shelterId, dogInformation, createdAt).let { dogViewRepository.save(it) }
    }
}