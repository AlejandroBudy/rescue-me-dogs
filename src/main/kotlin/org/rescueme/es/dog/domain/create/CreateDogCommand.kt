package org.rescueme.es.dog.domain.create

import org.axonframework.modelling.command.TargetAggregateIdentifier
import org.rescueme.es.shared.command.domain.Command

data class CreateDogCommand(
    @TargetAggregateIdentifier val id: String,
    val name: String,
    val breed: String,
    val shelterID: String
) : Command