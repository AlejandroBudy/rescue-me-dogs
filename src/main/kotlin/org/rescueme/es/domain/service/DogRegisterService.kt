package org.rescueme.es.domain.service

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.ports.inbound.DogRegister
import org.rescueme.es.domain.ports.outbound.DogsRegisterRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class DogRegisterService(private val dogsRegisterRepository: DogsRegisterRepository) : DogRegister {

    override fun registerDogInShelter(dog: Dog): Mono<Dog> =
            dogsRegisterRepository.registerDog(dog)
}