package org.rescueme.es.infrastructure.entry.model

import org.rescueme.es.domain.model.Shelter
import java.util.*


data class ShelterPayload(val uuid: String) {
    companion object {
        fun toDomain(uuid: String) =
                Shelter(String(Base64.getDecoder().decode(uuid)))


        fun fromDomain(shelter: Shelter) =
                shelter.uuid.let {
                    Base64.getEncoder().encodeToString(it.toByteArray())
                }.let { ShelterPayload(it) }

    }
}