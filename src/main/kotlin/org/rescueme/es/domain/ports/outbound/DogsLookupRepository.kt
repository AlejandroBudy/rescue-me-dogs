package org.rescueme.es.domain.ports.outbound

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter
import reactor.core.publisher.Flux

interface DogsLookupRepository {

    fun findByShelter(shelter: Shelter): Flux<Dog>
}