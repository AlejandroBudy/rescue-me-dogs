package org.rescueme.es.infrastructure.entry.model

import org.rescueme.es.domain.model.Shelter

data class ShelterPayload(val uuid: Int) {
    companion object {
        fun toDomain(uuid: String) = Shelter(uuid)
    }
}