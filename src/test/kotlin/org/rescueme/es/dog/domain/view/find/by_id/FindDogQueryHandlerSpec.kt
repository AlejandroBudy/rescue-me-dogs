package org.rescueme.es.dog.domain.view.find.by_id

import io.mockk.every
import io.mockk.mockk
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.jupiter.api.assertThrows
import org.rescueme.es.dog.application.view.find.by_id.FindDogQueryHandler
import org.rescueme.es.dog.createDogResponse
import org.rescueme.es.dog.createDogView
import org.rescueme.es.dog.createFindDogQuery
import org.rescueme.es.dog.dogIdVO
import org.rescueme.es.dog.domain.view.DogViewNotFoundException
import kotlin.test.assertEquals

class FindDogQueryHandlerSpec : Spek({

    val dogFinder = mockk<DogFinder>()
    val queryHandler = FindDogQueryHandler(dogFinder)

    describe("#${FindDogQueryHandler::on.name}") {
        on("Find dog query") {
            val dogView = createDogView()
            val query = createFindDogQuery()
            every { dogFinder.invoke(dogIdVO) } returns dogView
            val expected = createDogResponse()
            it("Should invoke finder ok") {
                val actual = queryHandler.on(query)
                assertEquals(expected, actual, "Dog response does not match expected")
            }
        }
        on("Dog not found exception") {
            val query = createFindDogQuery()
            every { dogFinder.invoke(dogIdVO) } throws DogViewNotFoundException("Error")
            it("Should invoke finder ok and throw exception") {
                val errorMessage =
                    assertThrows<DogViewNotFoundException> { queryHandler.on(query) }.message
                assertEquals("Error", errorMessage)
            }
        }
    }

})