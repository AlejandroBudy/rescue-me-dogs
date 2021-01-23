package org.rescueme.es.dog.adapter.create

import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class CreateDogController(private val commandBus: CommandBus) {

    @PostMapping("/dogs/{uuid}")
    fun registerDogInShelter(@PathVariable uuid: String, @RequestBody dog: CreateDogRequest): ResponseEntity<Unit> {
        val dogId = UUID.randomUUID().toString()
        commandBus.dispatch(dog.createCommand(dogId, uuid))
        return ResponseEntity.created(URI("/dogs/$dogId")).build()
    }

}