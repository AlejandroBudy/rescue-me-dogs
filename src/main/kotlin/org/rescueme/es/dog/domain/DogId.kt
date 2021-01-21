package org.rescueme.es.dog.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*

@ValueObject
class DogId(private val id: UUID) : Serializable {

    override fun toString() = id.toString()

    fun asString() = id.toString()

    companion object {
        fun fromString(uuid: String) = DogId(UUID.fromString(uuid))

    }
}