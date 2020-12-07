package org.rescueme.es.domain.ports.inbound

import org.rescueme.es.domain.model.Dog
import reactor.core.publisher.Mono

interface DogRegister {

    fun registerDogInShelter(dog: Dog): Mono<Dog>
}