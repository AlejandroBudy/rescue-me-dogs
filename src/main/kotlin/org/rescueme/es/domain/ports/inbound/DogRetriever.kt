package org.rescueme.es.domain.ports.inbound

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter

interface DogRetriever {

    fun findAllDogsByShelter(shelter: Shelter): List<Dog>
}