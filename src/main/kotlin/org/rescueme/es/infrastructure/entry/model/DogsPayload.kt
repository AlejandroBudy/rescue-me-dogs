package org.rescueme.es.infrastructure.entry.model

import org.rescueme.es.domain.model.Dog

data class DogsPayload(val id: String,
                       val name: String,
                       val breed: String) {
    companion object {
        fun fromDomain(dog: Dog) = DogsPayload(dog.uuid, dog.name, dog.breed)
    }
}