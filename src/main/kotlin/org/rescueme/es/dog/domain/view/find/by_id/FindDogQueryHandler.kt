package org.rescueme.es.dog.domain.view.find.by_id

import org.axonframework.queryhandling.QueryHandler
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.view.toResponse
import org.springframework.stereotype.Component

@Component
open class FindDogQueryHandler(private val dogFinder: DogFinder) {

    @QueryHandler
    open fun on(findDogQuery: FindDogQuery) =
        dogFinder(DogId.fromString(findDogQuery.id)).toResponse()
}