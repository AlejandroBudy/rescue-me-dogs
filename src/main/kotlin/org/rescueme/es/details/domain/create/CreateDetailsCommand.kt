package org.rescueme.es.details.domain.create

import org.rescueme.es.shared.command.domain.Command
import java.util.*

data class CreateDetailsCommand(
    val dogId: String,
    val birthDate: Date,
    val location: String,
    val color: String
) : Command