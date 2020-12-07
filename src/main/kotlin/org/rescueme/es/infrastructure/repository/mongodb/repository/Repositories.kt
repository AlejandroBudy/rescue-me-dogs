package org.rescueme.es.infrastructure.repository.mongodb.repository

import org.rescueme.es.infrastructure.repository.mongodb.model.DogEntity
import org.rescueme.es.infrastructure.repository.mongodb.model.ShelterEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface DogReactiveRepository : ReactiveMongoRepository<DogEntity, String> {
    fun findByShelter(shelter: ShelterEntity): Flux<DogEntity>
}