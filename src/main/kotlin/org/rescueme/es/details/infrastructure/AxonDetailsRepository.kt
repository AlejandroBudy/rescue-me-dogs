package org.rescueme.es.details.infrastructure

import org.rescueme.es.details.domain.Details
import org.rescueme.es.details.domain.DetailsId
import org.rescueme.es.details.domain.DogSpecification
import org.rescueme.es.details.domain.create.DetailsRepository
import org.rescueme.es.dog.domain.DogId
import org.springframework.stereotype.Component
import org.axonframework.modelling.command.Repository as AggregateRepository

@Component
class AxonDetailsRepository(private val persistenceRepository: AggregateRepository<Details>) : DetailsRepository {
    override fun new(detailsId: DetailsId, dogId: DogId, dogSpecification: DogSpecification) {
        persistenceRepository.newInstance {
            Details.create(detailsId, dogId, dogSpecification)
            Details()
        }
    }
}