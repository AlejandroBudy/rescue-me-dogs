package org.rescueme.es.infrastructure.repository.mongodb.model

import org.rescueme.es.domain.model.Shelter

data class ShelterEntity(val uuid: String) {
    companion object {
        fun fromDomain(shelter: Shelter) = ShelterEntity(shelter.uuid)
        fun toDomain(shelterEntity: ShelterEntity) = Shelter(shelterEntity.uuid)
    }
}