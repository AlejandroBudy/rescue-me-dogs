package org.rescueme.es.shelter.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*


@ValueObject
data class ShelterId(private val id: UUID) : Serializable {

    override fun toString() = id.toString()

    fun asString() = id.toString()

    companion object {
        fun fromString(uuid: String) = ShelterId(UUID.fromString(uuid))

    }
}