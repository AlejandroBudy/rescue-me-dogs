package org.rescueme.es.dog.domain

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class DogSpec : Spek({

    describe("#${Dog::onDogCreatedEvent.name}") {

        on("Dog created Event") {
            val event =
                it("") {

                }
        }
    }
})