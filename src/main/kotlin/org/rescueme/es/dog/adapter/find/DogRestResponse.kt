package org.rescueme.es.dog.adapter.find

import java.time.ZonedDateTime

data class DogRestResponse(val id: String,
                           val shelter: String,
                           val createdOn: ZonedDateTime,
                           val details: DogDetailsRestResponse)

data class DogDetailsRestResponse(val name: String, val breed: String)