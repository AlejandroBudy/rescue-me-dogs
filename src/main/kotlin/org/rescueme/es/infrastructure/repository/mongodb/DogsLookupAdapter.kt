package org.rescueme.es.infrastructure.repository.mongodb

import org.rescueme.es.domain.model.Shelter
import org.rescueme.es.domain.ports.outbound.DogsLookupRepository
import org.rescueme.es.infrastructure.repository.mongodb.model.DogEntity
import org.rescueme.es.infrastructure.repository.mongodb.model.ShelterEntity
import org.rescueme.es.infrastructure.repository.mongodb.repository.InMemoryDataBase
import org.springframework.stereotype.Component

@Component
class DogsLookupAdapter(private val dataRepository: InMemoryDataBase) : DogsLookupRepository {

    override fun findByShelter(shelter: Shelter) =
            shelter.let { ShelterEntity.fromDomain(it) }
                    .let { entity ->
                        dataRepository.inMemoryDogs
                                .filter { it.shelter == entity }
                                .also { println("Dogs found for shelter $shelter are: $it") }}
                    .map { DogEntity.toDomain(it) }
}