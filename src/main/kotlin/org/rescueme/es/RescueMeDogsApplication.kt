package org.rescueme.es

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class RescueMeDogsApplication

fun main(args: Array<String>) {
    runApplication<RescueMeDogsApplication>(*args)
}
