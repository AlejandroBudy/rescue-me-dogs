package org.rescueme.es.dog.domain

import org.rescueme.es.shared.valueobject.ValueObject

@ValueObject
data class DogInformation(
        val name: String,
        val breed: String)