package org.rescueme.es.dog.adapter

import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(DogViewNotFoundException::class)
    fun dogViewNotFound(e: DogViewNotFoundException) =
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message ?: "")
}