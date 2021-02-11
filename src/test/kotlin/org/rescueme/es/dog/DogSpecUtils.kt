package org.rescueme.es.dog

import org.rescueme.es.dog.adapter.create.CreateDogDetailsRequest
import org.rescueme.es.dog.adapter.create.CreateDogRequest
import org.rescueme.es.dog.adapter.find.DogDetailsRestResponse
import org.rescueme.es.dog.adapter.find.DogRestResponse
import org.rescueme.es.dog.application.DogDetails
import org.rescueme.es.dog.application.create.CreateDogCommand
import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.DogInformation
import org.rescueme.es.dog.domain.DogSpecification
import org.rescueme.es.dog.domain.create.DogCreatedEvent
import org.rescueme.es.dog.domain.view.DogDetailsResponse
import org.rescueme.es.dog.domain.view.DogResponse
import org.rescueme.es.dog.domain.view.DogView
import org.rescueme.es.dog.domain.view.find.by_id.FindDogQuery
import org.rescueme.es.dog.domain.view.find.by_shelter.FindDogByShelterQuery
import org.rescueme.es.shelter.domain.ShelterId
import java.time.ZonedDateTime
import java.util.*


const val shelterId: String = "15708b33-e1ad-4a4b-bb0a-af3c1307ab01"
const val dogId: String = "16722686-3a8d-4f03-aa8d-2ef1376c3d24"
const val name: String = "Budy"
const val breed: String = "bulldog"
const val location: String = "Madrid"
const val color: String = "green"

val dateTime: ZonedDateTime = ZonedDateTime.now()
val date: Date = Date()
val dogIdVO = DogId.fromString(dogId)
val shelterIdVO = ShelterId.fromString(shelterId)
val dogInformation = DogInformation(name, breed)

fun createDogRequest() =
    CreateDogRequest(
        shelterId = shelterId,
        detailsRequest = createDogDetailsRequest()
    )

fun createDogDetailsRequest() =
    CreateDogDetailsRequest(
        name = name,
        breed = breed,
        location = location,
        color = color,
        birthDate = date
    )

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
        breed = breed,
        location = location,
        color = color,
        birthDate = date.toString()
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
        breed = breed,
        location = location,
        color = color,
        birthDate = date.toString()
    )

fun createDogCreatedEvent() =
    DogCreatedEvent(
        aggregateId = dogId,
        occurredOn = dateTime,
        shelterId = shelterId,
        dogSpecification = createDogSpecification()
    )

fun createDogSpecification() =
    DogSpecification.create(
        date,
        location,
        color,
        name,
        breed
    )

fun createDogCommand() =
    CreateDogCommand(
        id = dogId,
        shelterID = shelterId,
        dogDetails = createDogDetails()
    )

fun createDogDetails() =
    DogDetails(
        breed = breed,
        name = name,
        birthDate = date,
        location = location,
        color = color
    )

fun createDogView() =
    DogView(
        dogIdVO,
        shelterIdVO,
        createDogSpecification(),
        dateTime,
        dateTime
    )

fun createFindDogQuery() =
    FindDogQuery(id = dogId)

fun createFindDogByShelterQuery() =
    FindDogByShelterQuery(id = shelterId)