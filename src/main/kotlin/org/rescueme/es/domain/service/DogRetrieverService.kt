package org.rescueme.es.domain.service

import org.rescueme.es.domain.model.Shelter
import org.rescueme.es.domain.ports.inbound.DogRetriever
import org.rescueme.es.domain.ports.outbound.DogsLookupRepository
import org.springframework.stereotype.Service

@Service
class DogRetrieverService(private val dogsLookupRepository: DogsLookupRepository) : DogRetriever {

    override fun findAllDogsByShelter(shelter: Shelter) =
            dogsLookupRepository.findByShelter(shelter)
}