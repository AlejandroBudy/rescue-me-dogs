package org.rescueme.es.dog.domain.create

import org.rescueme.es.shared.command.domain.Command

data class CreateDogCommand(
    val id: String,
    val name: String,
    val breed: String,
    val shelterID: String
) : Command