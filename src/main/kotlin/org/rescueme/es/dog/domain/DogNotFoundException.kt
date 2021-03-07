package org.rescueme.es.dog.domain

import java.lang.RuntimeException

class DogNotFoundException(msg: String) : RuntimeException(msg)