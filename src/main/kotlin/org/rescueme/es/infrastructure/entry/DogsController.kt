package org.rescueme.es.infrastructure.entry

import org.rescueme.es.configuration.logger
import org.rescueme.es.domain.ports.inbound.DogRegister
import org.rescueme.es.domain.ports.inbound.DogRetriever
import org.rescueme.es.infrastructure.entry.model.DogsPayload
import org.rescueme.es.infrastructure.entry.model.ShelterPayload
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RestController
class DogsController(private val dogRetriever: DogRetriever,
                     private val dogRegister: DogRegister) {

    @GetMapping("/dogs/{uuid}")
    fun getAllDogsInShelter(@PathVariable uuid: String): Flux<DogsPayload> =
            uuid.let { ShelterPayload.toDomain(uuid = it) }
                    .also { log.info("Looking for dogs int shelter $it") }
                    .let { dogRetriever.findAllDogsByShelter(it) }
                    .let { flux ->
                        flux.map { DogsPayload.fromDomain(it) }
                    }


    @PostMapping("/dogs/{uuid}")
    fun registerDogInShelter(@PathVariable uuid: String, @RequestBody dog: DogsPayload): Mono<DogsPayload> =
            dog.let { DogsPayload.toDomain(it, uuid) }
                    .also { log.info("Registering new dog $it in shelter $uuid") }
                    .let { dogRegister.registerDogInShelter(it) }
                    .let { mono -> mono.map { DogsPayload.fromDomain(it) } }

    companion object {
        val log by logger()
    }

}