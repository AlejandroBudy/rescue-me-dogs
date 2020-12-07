package org.rescueme.es.domain.ports.outbound

import org.rescueme.es.domain.model.Dog
import reactor.core.publisher.Mono

interface DogsRegisterRepository {

    fun registerDog(dog: Dog): Mono<Dog>
}