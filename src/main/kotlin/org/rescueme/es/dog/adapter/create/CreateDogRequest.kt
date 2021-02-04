package org.rescueme.es.dog.adapter.create

import org.rescueme.es.dog.application.create.CreateDogCommand

data class CreateDogRequest(
    val name: String,
    val breed: String
)

fun CreateDogRequest.createCommand(dogId: String, shelterUUID: String) =
    CreateDogCommand(dogId, name, breed, shelterUUID)