package org.rescueme.es.domain.ports.outbound

import org.rescueme.es.domain.model.Dog

interface DogsRegisterRepository {

    fun registerDog(dog: Dog): Dog
}