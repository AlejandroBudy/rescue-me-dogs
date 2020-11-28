package org.rescueme.es.domain.model

data class Dog(val uuid: String?,
               val name: String,
               val breed: String,
               val shelter: Shelter)