package org.rescueme.es.dog.adapter.create

import com.fasterxml.jackson.annotation.JsonProperty
import org.rescueme.es.dog.application.DogDetails
import org.rescueme.es.dog.application.create.CreateDogCommand
import java.util.*

data class CreateDogRequest(
    @JsonProperty("shelterIdentifier") val shelterId: String,
    @JsonProperty("details") val detailsRequest: CreateDogDetailsRequest
)

data class CreateDogDetailsRequest(
    val name: String?,
    val breed: String?,
    val birthDate: Date?,
    val location: String?,
    val color: String?
)

fun CreateDogRequest.createCommand(dogId: String) =
    CreateDogCommand(
        id = dogId,
        shelterID = shelterId,
        dogDetails = DogDetails(
            breed = detailsRequest.breed,
            name = detailsRequest.name,
            birthDate = detailsRequest.birthDate,
            location = detailsRequest.location,
            color = detailsRequest.color
        )
    )