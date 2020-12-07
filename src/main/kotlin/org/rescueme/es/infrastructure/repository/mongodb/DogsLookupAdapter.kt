package org.rescueme.es.infrastructure.repository.mongodb

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter
import org.rescueme.es.domain.ports.outbound.DogsLookupRepository
import org.rescueme.es.infrastructure.repository.mongodb.model.DogEntity
import org.rescueme.es.infrastructure.repository.mongodb.model.ShelterEntity
import org.rescueme.es.infrastructure.repository.mongodb.repository.DogReactiveRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class DogsLookupAdapter(private val dogRepository: DogReactiveRepository) : DogsLookupRepository {

    override fun findByShelter(shelter: Shelter): Flux<Dog> =
            shelter.let { ShelterEntity.fromDomain(it) }
                    .let { dogRepository.findByShelter(it) }
                    .let { flux -> flux.map { DogEntity.toDomain(it) } }

}
