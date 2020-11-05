package org.rescueme.es.domain.service

import org.rescueme.es.domain.model.Shelter
import org.rescueme.es.domain.ports.inbound.DogRetriever
import org.rescueme.es.domain.ports.outbound.DogsLookup
import org.springframework.stereotype.Service

@Service
class DogRetrieverImpl(private val dogsLookup: DogsLookup) : DogRetriever {

    override fun findAllDogsByShelter(shelter: Shelter) = dogsLookup.findByShelter(shelter)
}