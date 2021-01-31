package org.rescueme.es.details.adapter.create

import org.rescueme.es.shared.command.domain.CommandBus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class CreateDetailsController(private val commandBus: CommandBus) {

    @PostMapping("/dogs/{uuid}/details")
    fun createDetails(
        @PathVariable uuid: String,
        @RequestBody createDetailsRequest: CreateDetailsRequest
    ): ResponseEntity<Unit> {
        commandBus.dispatch(createDetailsRequest.toCommand(uuid))
        return ResponseEntity.created(URI("/dogs/$uuid/details")).build()
    }
}