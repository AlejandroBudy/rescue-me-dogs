package org.rescueme.es.details.domain.create

import org.rescueme.es.details.domain.DetailsId
import org.rescueme.es.details.domain.DogSpecification
import org.rescueme.es.dog.domain.DogId
import org.springframework.stereotype.Component

@Component
class DetailsCreator(private val repository: DetailsRepository) {

    operator fun invoke(detailsId: DetailsId, dogId: DogId, dogSpecification: DogSpecification) {
        repository.new(detailsId, dogId, dogSpecification)

    }
}