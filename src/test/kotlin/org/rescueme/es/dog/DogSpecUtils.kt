package org.rescueme.es.dog

import org.rescueme.es.dog.adapter.find.DogDetailsRestResponse
import org.rescueme.es.dog.adapter.find.DogRestResponse
import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.rescueme.es.dog.domain.view.DogDetailsResponse
import org.rescueme.es.dog.domain.view.DogResponse
import java.time.ZonedDateTime

val dateTime: ZonedDateTime = ZonedDateTime.now()

const val shelterId: String = "shelter"
const val dogId: String = "dogId"

fun createDogResponse() =
    DogResponse(
        id = "dogID",
        shelterId = "shelter",
        createdOn = dateTime,
        details = createDogDetailsResponse()
    )

fun createDogDetailsResponse() =
    DogDetailsResponse(
        name = "budy",
        breed = "bulldog"
    )


fun createDogRestResponse() =
    DogRestResponse(
        id = "dogID",
        shelter = "shelter",
        createdOn = dateTime,
        details = createDogDetailsRestResponse()
    )

fun createDogDetailsRestResponse() =
    DogDetailsRestResponse(
        name = "budy",
        breed = "bulldog"
    )

fun createDogCreatedEvent() =
    DogCreatedEvent(
        aggregateId = dogId,
        occurredOn = dateTime,
        shelterId = shelterId,
        dogInformation = createDogInformation()
    )

fun createDogInformation() =
    DogInformation(
        name = "Budy",
        breed = "bulldog"
    )