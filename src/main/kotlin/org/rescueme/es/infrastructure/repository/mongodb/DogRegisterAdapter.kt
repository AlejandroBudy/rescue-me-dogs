package org.rescueme.es.infrastructure.repository.mongodb

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.ports.outbound.DogsRegisterRepository
import org.rescueme.es.infrastructure.repository.mongodb.model.DogEntity
import org.rescueme.es.infrastructure.repository.mongodb.repository.InMemoryDataBase
import org.springframework.stereotype.Component

@Component
class DogRegisterAdapter(private val dataRepository: InMemoryDataBase) : DogsRegisterRepository {

    override fun registerDog(dog: Dog): Dog =
            dog.let { DogEntity.fromDomain(it) }
                    .let { dataRepository.save(it) }
                    .let { DogEntity.toDomain(it!!) }

}