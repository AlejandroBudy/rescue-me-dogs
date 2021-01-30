package org.rescueme.es.shelter.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*
import javax.persistence.Column


@ValueObject
data class ShelterId(@Column(columnDefinition = "binary(16)", name = "shelterId") private val id: UUID) : Serializable {

    override fun toString() = id.toString()

    fun asString() = id.toString()

    companion object {
        fun fromString(uuid: String): ShelterId {
            return ShelterId(UUID.fromString(uuid))
        }

    }
}