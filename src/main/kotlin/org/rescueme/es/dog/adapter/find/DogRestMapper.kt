package org.rescueme.es.dog.adapter.find

import org.rescueme.es.dog.domain.view.DogResponse

fun DogResponse.toRestResponse() =
    DogRestResponse(
        id,
        shelterId,
        createdOn,
        DogDetailsRestResponse(
            details.name,
            details.breed
        )
    )