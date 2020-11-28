package org.rescueme.es.infrastructure.repository.mongodb.repository

import org.rescueme.es.infrastructure.repository.mongodb.model.DogEntity
import org.rescueme.es.infrastructure.repository.mongodb.model.ShelterEntity
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class InMemoryDataBase {

    private val shelter1 = ShelterEntity("6c518f05-bfd9-42b5-baf1-6866d9506bc3")
    private val shelter2 = ShelterEntity("8a5d05f0-6e05-43bb-bc36-3cd35b3efa0d")

    val inMemoryDogs: MutableList<DogEntity> = mutableListOf(
            DogEntity(UUID.randomUUID().toString(), "Kitty", "Bichon", shelter1),
            DogEntity(UUID.randomUUID().toString(), "Donna", "Husky", shelter1),
            DogEntity(UUID.randomUUID().toString(), "Brador", "Pitbull", shelter1),
            DogEntity(UUID.randomUUID().toString(), "Pitbull", "Pitbull", shelter1),
            DogEntity(UUID.randomUUID().toString(), "Ares", "American bully", shelter1),
            DogEntity(UUID.randomUUID().toString(), "other", "unknown", shelter2),
            DogEntity(UUID.randomUUID().toString(), "Kira", "Labrador", shelter2))
   init {
       println(shelter1)
       println(shelter2)
   }

    fun save(dogEntity: DogEntity): DogEntity? {
        inMemoryDogs.add(dogEntity)
        return inMemoryDogs.find { entity -> dogEntity == entity }
    }
}