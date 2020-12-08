package org.rescueme.es.infrastructure.entry.api

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.rescueme.es.domain.ports.inbound.DogRegister
import org.rescueme.es.domain.ports.inbound.DogRetriever
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import reactor.test.StepVerifier

object DogsControllerSpec : Spek({

    val dogRetriever: DogRetriever = mockk()
    val dogRegister: DogRegister = mockk()
    val controller = DogsController(dogRetriever, dogRegister)


    describe("Request controller to get all dogs in shelter") {

        context("Retrieve all existing dogs in shelter") {
            it("Should return one dogs in shelter") {
                every { dogRetriever.findAllDogsByShelter(createDomainShelter()) } returns createFluxDomainDog()
                val actual = controller.getAllDogsInShelter(idShelterEncoded)
                StepVerifier.create(actual.log())
                        .expectNext(createDogPayload())
                        .verifyComplete()
                verify(atLeast = 1) { dogRetriever.findAllDogsByShelter(createDomainShelter()) }
            }
            it("Should return multiple dogs in shelter") {
                every { dogRetriever.findAllDogsByShelter(createDomainShelter()) } returns createFluxMultipleDomainDog()
                val actual = controller.getAllDogsInShelter(idShelterEncoded)
                StepVerifier.create(actual.log())
                        .expectNext(createDogPayload())
                        .expectNext(createDogPayload_2())
                        .verifyComplete()
                verify(atLeast = 1) { dogRetriever.findAllDogsByShelter(createDomainShelter()) }
            }
        }
        context("None dogs exists in shelter") {
            it("Should return empty flux") {
                every { dogRetriever.findAllDogsByShelter(createDomainShelter()) } returns createFluxDomainDogEmpty()
                val actual = controller.getAllDogsInShelter(idShelterEncoded)
                StepVerifier.create(actual.log())
                        .verifyComplete()
                verify(atLeast = 1) { dogRetriever.findAllDogsByShelter(createDomainShelter()) }
            }
        }
    }

    describe("Request controller to register dog in shelter") {

    }
})