package org.rescueme.es.dog.domain.view

import org.rescueme.es.dog.domain.DogSpecification

fun DogView.toResponse() =
    DogResponse(
        id.asString(),
        shelterId.asString(),
        createdOn,
        dogSpecification.toResponse()
    )

fun DogSpecification.toResponse() =
    DogDetailsResponse(
        name = name,
        breed = breed,
        birthDate = birthDate.toString(),
        location = location,
        color = color?.value
    )
