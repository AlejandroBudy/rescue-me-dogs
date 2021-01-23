package org.rescueme.es.dog.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*
import javax.persistence.Column

@ValueObject
class DogId(@Column(columnDefinition = "binary(16)", name = "dogId") private val id: UUID) : Serializable {

    override fun toString() = id.toString()

    fun asString() = id.toString()

    companion object {
        fun fromString(uuid: String) = DogId(UUID.fromString(uuid))

    }
}