package org.rescueme.es.domain.ports.inbound

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter
import reactor.core.publisher.Flux

interface DogRetriever {

    fun findAllDogsByShelter(shelter: Shelter): Flux<Dog>
}