package org.rescueme.es.infrastructure.entry.model

import org.rescueme.es.domain.model.Dog
import java.util.*

data class DogsPayload(val id: String?,
                       val name: String,
                       val breed: String,
                       val shelterPayload: ShelterPayload?) {
    companion object {
        fun fromDomain(dog: Dog) =
                DogsPayload(
                        dog.uuid?.let { Base64.getEncoder().encodeToString(it.toByteArray()) },
                        dog.name,
                        dog.breed,
                        ShelterPayload.fromDomain(dog.shelter))

        fun toDomain(dogsPayload: DogsPayload, shelterUUID: String) =
                Dog(uuid = null,
                        name = dogsPayload.name,
                        breed = dogsPayload.breed,
                        shelter = ShelterPayload.toDomain(shelterUUID))
    }

}