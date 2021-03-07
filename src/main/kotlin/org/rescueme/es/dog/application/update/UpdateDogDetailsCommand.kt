package org.rescueme.es.dog.application.update

import org.rescueme.es.dog.application.DogDetails
import org.rescueme.es.shared.command.domain.Command

data class UpdateDogDetailsCommand(
    val dogId: String,
    val dogDetails: DogDetails
) : Command