package org.rescueme.es.dog.infrastructure.view

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.createDogView
import org.rescueme.es.dog.dogIdVO
import org.rescueme.es.dog.shelterIdVO
import java.util.*
import kotlin.test.assertEquals

class DogViewJpaRepositorySpec : Spek({

    val jpaRepository = mockk<DogViewJpaPersistenceRepository>()
    val repository = DogViewJpaRepository(jpaRepository)

    describe("#${DogViewJpaRepository::save.name}") {
        val request = createDogView()
        on("Saving dog request") {
            every { jpaRepository.save(request) } returns request
            it("Should invoke jpa repository to save") {
                repository.save(request)
                verify(exactly = 1) { jpaRepository.save(request) }
            }
        }
    }

    describe("#${DogViewJpaRepository::find.name}") {
        val view = createDogView()
        on("Find by existing dog") {
            every { jpaRepository.findById(dogIdVO) } returns Optional.of(view)
            it("Should return existing dog view ") {
                val actual = repository.find(dogIdVO)
                assertEquals(view, actual, "Result returned does not match")
            }
        }

        on("Find by not existing dog") {
            every { jpaRepository.findById(dogIdVO) } returns Optional.empty()
            it("Should return null") {
                val actual = repository.find(dogIdVO)
                assertEquals(null, actual, "Result returned does not match")
            }
        }
    }

    describe("#${DogViewJpaRepository::findByShelter.name}") {
        val view = createDogView()
        on("Find by existing shelter") {
            every { jpaRepository.findByShelterId(shelterIdVO) } returns view
            it("Should return existing dog") {
                val actual = repository.findByShelter(shelterIdVO)
                assertEquals(view, actual, "Result returned does not match")
            }
        }

        on("Find by not existing shelter") {
            every { jpaRepository.findByShelterId(shelterIdVO) } returns null
            it("Should return null") {
                val actual = repository.findByShelter(shelterIdVO)
                assertEquals(null, actual, "Result returned does not match")
            }
        }
    }

})