package org.rescueme.es.dog.adapter.update

import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateDogDetailsController(private val commandBus: CommandBus) {

    @PutMapping("/dogs/{uuid}")
    fun updateDetails(
        @PathVariable uuid: String,
        @RequestBody updateDetailsRequest: UpdateDogDetailsRequest
    ): ResponseEntity<Unit> {
        commandBus.dispatch(updateDetailsRequest.toCommand(uuid))
        return ResponseEntity.accepted().build()
    }
}