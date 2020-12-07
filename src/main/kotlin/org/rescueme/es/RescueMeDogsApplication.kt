package org.rescueme.es

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication(exclude = [WebMvcAutoConfiguration::class])
@EnableWebFlux
@EnableReactiveMongoRepositories
class RescueMeDogsApplication

fun main(args: Array<String>) {
    runApplication<RescueMeDogsApplication>(*args)
}
