package org.rescueme.es.domain.ports.outbound

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter

interface DogsLookupRepository {

    fun findByShelter(shelter: Shelter): List<Dog>
}