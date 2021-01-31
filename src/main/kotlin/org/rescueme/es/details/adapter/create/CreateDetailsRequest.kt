package org.rescueme.es.details.adapter.create

import org.rescueme.es.details.domain.create.CreateDetailsCommand
import java.util.*

data class CreateDetailsRequest(
    val birthDate: Date,
    val location: String,
    val color: String
)

fun CreateDetailsRequest.toCommand(uuid: String) =
    CreateDetailsCommand(
        uuid,
        birthDate,
        location,
        color
    )
