package org.rescueme.es.domain.ports.inbound

import org.rescueme.es.domain.model.Dog

interface DogRegister {

    fun registerDogInShelter(dog: Dog): Dog
}