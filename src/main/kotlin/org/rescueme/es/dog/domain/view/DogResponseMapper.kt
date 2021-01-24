package org.rescueme.es.dog.domain.view

import org.rescueme.es.dog.domain.DogInformation

fun DogView.toResponse() =
        DogResponse(id.asString(),
                shelterId.asString(),
                createdOn,
                information.toResponse())

fun DogInformation.toResponse() =
        DogDetailsResponse(name, breed)
