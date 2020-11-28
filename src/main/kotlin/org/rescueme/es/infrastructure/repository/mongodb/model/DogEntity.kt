package org.rescueme.es.infrastructure.repository.mongodb.model

import org.rescueme.es.domain.model.Dog
import java.util.*

data class DogEntity(val uuid: String,
                     val name: String,
                     val breed: String,
                     val shelter: ShelterEntity) {
    companion object {
        fun fromDomain(dog: Dog) =
                DogEntity(
                        dog.uuid ?: UUID.randomUUID().toString(),
                        dog.name,
                        dog.breed,
                        ShelterEntity.fromDomain(dog.shelter))

        fun toDomain(dogEntity: DogEntity) =
                Dog(dogEntity.uuid, dogEntity.name, dogEntity.breed, ShelterEntity.toDomain(dogEntity.shelter))
    }
}