package org.rescueme.es.dog.adapter.find

import org.rescueme.es.dog.domain.view.DogResponse
import org.rescueme.es.dog.domain.view.find.by_id.FindDogQuery
import org.rescueme.es.dog.domain.view.find.by_shelter.FindDogByShelterQuery
import org.rescueme.es.shared.query.domain.QueryBus
import org.rescueme.es.shared.query.domain.ask
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindDogController(private val queryBus: QueryBus) {

    @GetMapping("/dogs/{dogId}")
    fun findById(@PathVariable("dogId") id: String) =
        queryBus.ask<DogResponse>(FindDogQuery(id))
            .thenApply { it.toRestResponse() }
            .thenApply { ResponseEntity.ok(it) }
            .exceptionally { ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() }

    @GetMapping("/dogs/shelter/{shelterId}")
    fun findByShelter(@PathVariable("shelterId") shelterId: String) =
        queryBus.ask<DogResponse>(FindDogByShelterQuery(shelterId))
            .thenApply { it.toRestResponse() }
            .thenApply { ResponseEntity.ok(it) }
            .exceptionally { ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() }


}