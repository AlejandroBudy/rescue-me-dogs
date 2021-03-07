package org.rescueme.es.dog.domain.view.find.by_shelter

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.assertThrows
import org.rescueme.es.dog.createDogView
import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.rescueme.es.dog.shelterIdVO
import kotlin.test.assertEquals

class DogByShelterFinderSpec : Spek({

    val dogViewRepository = mockk<DogViewRepository>()
    val finder = DogByShelterFinder(dogViewRepository)

    describe("#${DogByShelterFinder::invoke.name}") {
        on("Find by shelter in repository") {
            val expected = createDogView()
            every { dogViewRepository.findByShelter(shelterIdVO) } returns expected
            it("Should return dog from repository") {
                val actual = finder(shelterIdVO)
                assertEquals(expected, actual)
                verify(exactly = 1) { dogViewRepository.findByShelter(shelterIdVO) }
            }
        }

        on("Find by shelter in repository not found") {
            every { dogViewRepository.findByShelter(shelterIdVO) } returns null
            it("Should return dog from repository") {
                assertThrows<DogViewNotFoundException> { finder(shelterIdVO) }
                verify(exactly = 1) { dogViewRepository.findByShelter(shelterIdVO) }
            }
        }
    }
})