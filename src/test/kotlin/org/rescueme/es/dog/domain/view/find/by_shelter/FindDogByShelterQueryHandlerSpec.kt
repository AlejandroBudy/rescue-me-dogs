package org.rescueme.es.dog.domain.view.find.by_shelter

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.assertThrows
import org.rescueme.es.dog.createDogResponse
import org.rescueme.es.dog.createDogView
import org.rescueme.es.dog.createFindDogByShelterQuery
import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import org.rescueme.es.dog.shelterIdVO
import kotlin.test.assertEquals

class FindDogByShelterQueryHandlerSpec : Spek({

    val finder = mockk<DogByShelterFinder>()
    val handler = FindDogByShelterQueryHandler(finder)

    describe("#${FindDogByShelterQueryHandler::on.name}") {
        on("Find dog by shelter query") {
            val expected = createDogResponse()
            every { finder.invoke(shelterIdVO) } returns createDogView()
            it("Should return dog response") {
                val actual = handler.on(createFindDogByShelterQuery())
                assertEquals(expected, actual)
                verify(exactly = 1) { finder.invoke(shelterIdVO) }
            }
        }

        on("Find dog not existing by shelter query") {
            every { finder.invoke(shelterIdVO) } throws DogViewNotFoundException("error")
            it("Should throw exception") {
                assertThrows<DogViewNotFoundException> { handler.on(createFindDogByShelterQuery()) }
            }
        }
    }
})