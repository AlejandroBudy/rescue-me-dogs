package org.rescueme.es.dog.application.create

import org.rescueme.es.dog.application.DogDetails
import org.rescueme.es.shared.command.domain.Command

data class CreateDogCommand(
    val id: String,
    val shelterID: String,
    val dogDetails: DogDetails
) : Command
