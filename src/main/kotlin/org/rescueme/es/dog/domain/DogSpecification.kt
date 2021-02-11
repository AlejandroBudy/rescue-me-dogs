package org.rescueme.es.dog.domain

import org.rescueme.es.shared.valueobject.ValueObject
import java.io.Serializable
import java.util.*
import javax.persistence.Column

@ValueObject
class DogSpecification(
    private var id_: UUID?,
    private val birthDate_: Date?,
    private val location_: String?,
    private val color_: Color?,
    private val name_: String?,
    private val breed_: String?
) : Serializable {


    @Column(columnDefinition = "binary(16)", name = "specification")
    val id: UUID = id_ ?: UUID.randomUUID()
    var birthDate: Date? = birthDate_
        private set
    var location: String? = location_
        private set
    var color: Color? = color_
        private set
    var name: String? = name_
        private set
    var breed: String? = breed_
        private set

    fun update(dogSpecification: DogSpecification) {
        birthDate = dogSpecification.birthDate.takeIf { isNotNull(it) }
        location = dogSpecification.location.takeIf { isNotNull(it) }
        color = dogSpecification.color.takeIf { isNotNull(it) }
        name = dogSpecification.name.takeIf { isNotNull(it) }
        breed = dogSpecification.breed.takeIf { isNotNull(it) }
    }

    companion object {
        fun create(
            birthDate: Date? = null,
            location: String? = null,
            color: String? = null,
            name: String? = null,
            breed: String? = null
        ) =
            DogSpecification(
                id_ = UUID.randomUUID(),
                birthDate_ = birthDate,
                location_ = location,
                color_ = if (color != null) Color.fromString(color) else null,
                name_ = name,
                breed_ = breed
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


fun <T : Any> isNotNull(value: T?): Boolean {
    return value != null
}
