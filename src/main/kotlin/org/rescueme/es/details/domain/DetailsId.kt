package org.rescueme.es.details.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*
import javax.persistence.Column

@ValueObject
class DetailsId(@Column(columnDefinition = "binary(16)", name = "detailsId") private val id: UUID) : Serializable {

    override fun toString() = id.toString()

    fun asString() = id.toString()

    companion object {
        fun fromString(uuid: String) = DetailsId(UUID.fromString(uuid))
        fun generate() = DetailsId(UUID.randomUUID())

    }
}