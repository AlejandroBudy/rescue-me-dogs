package org.rescueme.es.dog.domain.view.find.by_shelter

import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component

@Component
class DogByShelterFinder(private val dogViewRepository: DogViewRepository) {
    operator fun invoke(id: ShelterId) =
        dogViewRepository.findByShelter(id).also {
            it ?: throw DogViewNotFoundException("Dogs for shelter $id not found")
        }!!

}