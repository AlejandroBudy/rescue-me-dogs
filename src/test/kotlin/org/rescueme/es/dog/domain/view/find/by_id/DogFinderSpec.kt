package org.rescueme.es.dog.domain.view.find.by_id

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.assertThrows
import org.rescueme.es.dog.createDogView
import org.rescueme.es.dog.dogIdVO
import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.rescueme.es.dog.domain.view.DogViewRepository
import kotlin.test.assertEquals

class DogFinderSpec : Spek({

    val repository = mockk<DogViewRepository>()
    val dogFinder = DogFinder(repository)

    describe("#${DogFinder::invoke.name}") {
        on("Request finder repository dog view exits") {
            val expected = createDogView()
            every { repository.find(dogIdVO) } returns expected
            it("Should return view retrieved") {
                val actual = dogFinder.invoke(dogIdVO)
                assertEquals(expected, actual)
                verify(exactly = 1) { repository.find(dogIdVO) }
            }
        }
        on("Request finder repository dog view does not exits") {
            every { repository.find(dogIdVO) } returns null
            it("Should return view retrieved") {
                assertThrows<DogViewNotFoundException> { dogFinder.invoke(dogIdVO) }
                verify(exactly = 1) { repository.find(dogIdVO) }
            }
        }
    }
})
