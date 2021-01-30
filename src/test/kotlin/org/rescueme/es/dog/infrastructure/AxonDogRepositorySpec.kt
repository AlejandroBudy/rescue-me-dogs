import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.axonframework.modelling.command.Aggregate
import org.axonframework.modelling.command.Repository
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.createDogInformation
import org.rescueme.es.dog.dogIdVO
import org.rescueme.es.dog.domain.Dog
import org.rescueme.es.dog.infrastructure.AxonDogRepository
import org.rescueme.es.dog.shelterIdVO

class AxonDogRepositorySpec : Spek({

    val aggregateRepository = mockk<Repository<Dog>>()
    val axonRepository = AxonDogRepository(aggregateRepository)

    describe("#${AxonDogRepository::new.name}") {

        on("Aggregate creation") {
            val aggregate: Aggregate<Dog> = mockk()
            every { aggregateRepository.newInstance(any()) } returns aggregate
            it("Should create Aggregate instance") {
                axonRepository.new(dogIdVO, shelterIdVO, createDogInformation())
                verify(exactly = 1) { aggregateRepository.newInstance(any()) }
            }
        }
    }
})