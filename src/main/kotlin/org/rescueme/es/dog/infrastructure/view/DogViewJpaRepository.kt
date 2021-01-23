package org.rescueme.es.dog.infrastructure.view

import org.rescueme.es.dog.domain.DogId
import org.rescueme.es.dog.domain.view.DogView
import org.rescueme.es.dog.domain.view.DogViewRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
open class DogViewJpaRepository(private val jpaPersistenceRepository: DogViewJpaPersistenceRepository) : DogViewRepository {
    override fun save(dogView: DogView) {
        jpaPersistenceRepository.save(dogView)
    }
}

interface DogViewJpaPersistenceRepository : JpaRepository<DogView, DogId>
