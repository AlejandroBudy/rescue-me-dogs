package org.rescueme.es.dog

import org.rescueme.es.dog.adapter.find.DogDetailsRestResponse
import org.rescueme.es.dog.adapter.find.DogRestResponse
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.dog.domain.create.CreateDogCommand
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.rescueme.es.dog.domain.view.DogDetailsResponse
import org.rescueme.es.dog.domain.view.DogResponse
import org.rescueme.es.shelter.domain.ShelterId
import java.time.ZonedDateTime


const val shelterId: String = "15708b33-e1ad-4a4b-bb0a-af3c1307ab01"
const val dogId: String = "16722686-3a8d-4f03-aa8d-2ef1376c3d24"
const val name: String = "Budy"
const val breed: String = "bulldog"

val dateTime: ZonedDateTime = ZonedDateTime.now()
val dogIdVO = DogId.fromString(dogId)
val shelterIdVO = ShelterId.fromString(shelterId)
val dogInformation = DogInformation(name, breed)

fun createDogResponse() =
    DogResponse(
        id = dogId,
        shelterId = shelterId,
        createdOn = dateTime,
        details = createDogDetailsResponse()
    )

fun createDogDetailsResponse() =
    DogDetailsResponse(
        name = name,
        breed = breed
    )


fun createDogRestResponse() =
    DogRestResponse(
        id = dogId,
        shelter = shelterId,
        createdOn = dateTime,
        details = createDogDetailsRestResponse()
    )

fun createDogDetailsRestResponse() =
    DogDetailsRestResponse(
        name = name,
        breed = breed
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
        name = name,
        breed = breed
    )

fun createDogCommand() =
    CreateDogCommand(
        id = dogId,
        name = name,
        breed = breed,
        shelterID = shelterId
    )