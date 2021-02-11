package org.rescueme.es.dog.adapter.update

import org.rescueme.es.dog.application.DogDetails
import org.rescueme.es.dog.application.update.UpdateDogDetailsCommand
import java.util.*

data class UpdateDogDetailsRequest(
    val name: String?,
    val breed: String?,
    val birthDate: Date?,
    val location: String?,
    val color: String?
)

fun UpdateDogDetailsRequest.toCommand(uuid: String) =
    UpdateDogDetailsCommand(
        uuid,
        dogDetails = DogDetails(
            breed = breed,
            name = name,
            birthDate = birthDate,
            location = location,
            color = color
        )
    )
