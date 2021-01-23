package org.rescueme.es.dog.domain.view

import java.time.ZonedDateTime

data class DogResponse(
        val id: String,
        val shelterId: String,
        val createdOn: ZonedDateTime,
        val details: DogDetailsResponse)

data class DogDetailsResponse(val name: String,
                              val breed: String)