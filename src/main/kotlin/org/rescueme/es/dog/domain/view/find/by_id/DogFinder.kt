package org.rescueme.es.dog.domain.view.find.by_id

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.springframework.stereotype.Component

@Component
class DogFinder(private val repository: DogViewRepository) {

    operator fun invoke(id: DogId) =
        repository.find(id).also { it ?: throw DogViewNotFoundException("Dog with id: $id does not exists") }!!
}