package org.rescueme.es.details.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*
import javax.persistence.Column

@ValueObject
class DogSpecification(
    private var id_: UUID?,
    private val birthDate_: Date,
    private val location_: String,
    private val color_: Color
) : Serializable {

    @Column(columnDefinition = "binary(16)", name = "specification")
    val id: UUID = id_ ?: UUID.randomUUID()
    val birthDate: Date = birthDate_
    val location: String = location_
    val color: Color = color_

    companion object {
        fun create(birthDate: Date, location: String, color: String) =
            DogSpecification(
                id_ = UUID.randomUUID(),
                birthDate_ = birthDate,
                location_ = location,
                color_ = Color.fromString(color)
            )

    }


}

enum class Color(val value: String) {
    GREEN("green"),
    BLUE("blue"),
    NOT_SPECIFIED("none");

    companion object {
        fun fromString(value: String): Color =
            values().firstOrNull { it.value == value } ?: NOT_SPECIFIED
    }
}