package org.rescueme.es.dog.adapter.find

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.assertThrows
import org.rescueme.es.dog.createDogResponse
import org.rescueme.es.dog.createDogRestResponse
import org.rescueme.es.dog.dogId
import org.rescueme.es.dog.domain.view.DogResponse
import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.rescueme.es.dog.domain.view.find.by_id.FindDogQuery
import org.rescueme.es.dog.domain.view.find.by_shelter.FindDogByShelterQuery
import org.rescueme.es.dog.shelterId
import org.rescueme.es.shared.query.domain.ask
import org.rescueme.es.shared.query.infrastructure.QueryBusAxon
import org.springframework.http.ResponseEntity
import java.util.concurrent.CompletableFuture
import kotlin.test.assertEquals

class FindDogControllerSpec : Spek({


    val queryBus = mockk<QueryBusAxon>()
    val controller = FindDogController(queryBus)

    describe("#${FindDogController::findById.name}") {
        val request = FindDogQuery(dogId)

        on("Query bus return response ok") {
            every { queryBus.ask<DogResponse>(request) } returns
                    CompletableFuture.supplyAsync { createDogResponse() }

            val actual = controller.findById(dogId).getNow(null)

            it("Should return response entity ok") {
                assertEquals(
                        ResponseEntity.ok(createDogRestResponse()), actual, "Response does not match")

                verify(exactly = 1) { queryBus.ask<DogResponse>(request) }
            }
        }

        on("QueryBus throws exception not found dog") {
            every { queryBus.ask<Any>(request) } returns
                    CompletableFuture.completedFuture(DogViewNotFoundException("Error"))


            it("Should return response entity ok") {
                assertThrows<DogViewNotFoundException> { controller.findById(dogId).getNow(null) }

                verify(exactly = 1) { queryBus.ask<DogResponse>(request) }
            }
        }
    }

    describe("#${FindDogController::findByShelter.name}") {
        val request = FindDogByShelterQuery(shelterId)

        on("Query bus return response ok") {

            every { queryBus.ask<DogResponse>(request) } returns CompletableFuture.supplyAsync { createDogResponse() }

            val actual = controller.findByShelter(shelterId).getNow(null)

            it("Should return response entity ok") {
                assertEquals(
                        ResponseEntity.ok(createDogRestResponse()), actual, "Response does not match")

                verify(exactly = 1) { queryBus.ask<DogResponse>(request) }
            }
        }

        on("QueryBus throws exception not found dog") {
            every { queryBus.ask<Any>(request) } returns
                    CompletableFuture.completedFuture(DogViewNotFoundException("Error"))


            it("Should return response entity ok") {
                assertThrows<DogViewNotFoundException> {
                    controller.findByShelter(shelterId).getNow(null)
                }

                verify(exactly = 1) { queryBus.ask<DogResponse>(request) }
            }
        }
    }
})