package org.rescueme.es.dog.domain.view.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.*
import org.rescueme.es.dog.domain.view.DogViewRepository

class DogViewCreatorSpec : Spek({

    val dogViewRepository = mockk<DogViewRepository>()
    val creator = DogViewCreator(dogViewRepository)

    describe("#${DogViewCreator::invoke.name}") {
        on("Invocation to dog create") {
            every { dogViewRepository.save(createDogView()) } returns Unit
            it("Should invoke repository to save dog view") {
                creator.invoke(dogIdVO, shelterIdVO, createDogSpecification(), dateTime)
                verify(exactly = 1) { dogViewRepository.save(createDogView()) }
            }
        }
    }

})