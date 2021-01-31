package org.rescueme.es.details.domain.create

import org.rescueme.es.details.domain.DetailsId
import org.rescueme.es.details.domain.DogSpecification
import org.rescueme.es.dog.domain.DogId

interface DetailsRepository {
    fun new(detailsId: DetailsId, dogId: DogId, dogSpecification: DogSpecification)
}