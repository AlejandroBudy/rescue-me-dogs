package org.rescueme.es.infrastructure.repository.mongodb

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter
import org.rescueme.es.domain.ports.outbound.DogsLookup
import org.springframework.stereotype.Component

@Component
class DogsLookupAdapter : DogsLookup {

    private val inMemoryDogs: List<Dog>
        get() = listOf(
                Dog("shelter-1", "Budy", "bulldog"),
                Dog("shelter-1", "Kitty", "Bichon"),
                Dog("shelter-1", "Donna", "Husky"),
                Dog("shelter-2", "Brador", "Pitbull"),
                Dog("shelter-2", "Pitbull", "Pitbull"),
                Dog("shelter-2", "Ares", "American bully"),
                Dog("shelter-2", "other", "unknown"),
                Dog("shelter-1", "Kira", "Labrador"))

    override fun findByShelter(shelter: Shelter) =
            inMemoryDogs.filter { it.uuid == shelter.uuid }
                    .also { println("Dogs found for shelter $shelter are: $it") }
}