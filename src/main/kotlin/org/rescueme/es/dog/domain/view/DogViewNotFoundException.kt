package org.rescueme.es.dog.domain.view

class DogViewNotFoundException (id: String) : RuntimeException("Dog with id: $id does not exists")