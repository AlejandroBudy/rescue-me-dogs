package org.rescueme.es.dog.domain.view

import org.rescueme.es.dog.domain.DogDetails

fun DogView.toResponse() =
        DogResponse(id.asString(),
                shelterId.asString(),
                createdOn,
                details.toResponse())

fun DogDetails.toResponse() =
        DogDetailsResponse(name, breed)
