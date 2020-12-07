package org.rescueme.es.infrastructure.repository.mongodb

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.ports.outbound.DogsRegisterRepository
import org.rescueme.es.infrastructure.repository.mongodb.model.DogEntity
import org.rescueme.es.infrastructure.repository.mongodb.repository.DogReactiveRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class DogRegisterAdapter(private val dogReactiveRepository: DogReactiveRepository) : DogsRegisterRepository {

    override fun registerDog(dog: Dog): Mono<Dog> =
            dog.let { DogEntity.fromDomain(it) }
                    .let { dogReactiveRepository.save(it) }
                    .let { mono -> mono.map { DogEntity.toDomain(it) } }

}