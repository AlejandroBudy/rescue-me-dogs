package org.rescueme.es.infrastructure.repository.mongodb.model

import org.rescueme.es.domain.model.Dog
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

@Document(collection = "dogs")
data class DogEntity(@Id @Field("_id") val id: String?,
                     val uuid: String,
                     val name: String,
                     val breed: String,
                     val shelter: ShelterEntity) {
    companion object {
        fun fromDomain(dog: Dog) =
                DogEntity(null,
                        dog.uuid ?: UUID.randomUUID().toString(),
                        dog.name,
                        dog.breed,
                        ShelterEntity.fromDomain(dog.shelter))

        fun toDomain(dogEntity: DogEntity) =
                Dog(dogEntity.uuid, dogEntity.name, dogEntity.breed, ShelterEntity.toDomain(dogEntity.shelter))
    }
}