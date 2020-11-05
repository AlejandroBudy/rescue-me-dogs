package org.rescueme.es.infrastructure.entry

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.ports.inbound.DogRetriever
import org.rescueme.es.infrastructure.entry.model.DogsPayload
import org.rescueme.es.infrastructure.entry.model.ShelterPayload
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class DogsController(private val dogRetriever: DogRetriever) {

    @GetMapping("/dogs/{uuid}")
    fun getAllDogsInShelter(@PathVariable uuid: String) =
            uuid.let { ShelterPayload.toDomain(uuid = it) }
                    .also { println("Looking for dogs int shelter $it") }
                    .let { dogRetriever.findAllDogsByShelter(it) }
                    .let { list: List<Dog> ->
                        list.map { DogsPayload.fromDomain(it) }
                    }
                    .let { ResponseEntity(it, HttpStatus.OK) }


}