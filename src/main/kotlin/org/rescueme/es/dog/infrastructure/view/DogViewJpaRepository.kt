package org.rescueme.es.dog.infrastructure.view

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.view.DogView
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
open class DogViewJpaRepository(private val jpaPersistenceRepository: DogViewJpaPersistenceRepository) : DogViewRepository {
    override fun save(dogView: DogView) {
        jpaPersistenceRepository.save(dogView)
    }

    override fun find(id: DogId) =
            jpaPersistenceRepository.findByIdOrNull(id)

    override fun findByShelter(id: ShelterId): DogView?  =
            jpaPersistenceRepository.findByShelterId(id)

}

interface DogViewJpaPersistenceRepository : JpaRepository<DogView, DogId> {
    fun findByShelterId(id: ShelterId): DogView?
}
