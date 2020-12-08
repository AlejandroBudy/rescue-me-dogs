package org.rescueme.es.infrastructure.entry

import org.rescueme.es.domain.model.Dog
import org.rescueme.es.domain.model.Shelter
import org.rescueme.es.infrastructure.entry.model.DogsPayload
import org.rescueme.es.infrastructure.entry.model.ShelterPayload
import reactor.core.publisher.Flux

const val idEncoded = "NmM1MThmMDUtYmZkOS00MmI1LWJhZjEtNjg2NmQ5NTA2YmMz"
const val idShelterEncoded = "OGE1ZDA1ZjAtNmUwNS00M2JiLWJjMzYtM2NkMzViM2VmYTBk"
const val id = "6c518f05-bfd9-42b5-baf1-6866d9506bc3"
const val idShelter = "8a5d05f0-6e05-43bb-bc36-3cd35b3efa0d"
const val name = " Budy"
const val breed = "Bulldog"

fun createFluxDogPayload(): Flux<DogsPayload> = Flux.fromArray(arrayOf(createDogPayload()))
fun createDogPayload(): DogsPayload = DogsPayload(idEncoded, name, breed, createShelterPayload())
fun createShelterPayload(): ShelterPayload = ShelterPayload(idShelterEncoded)
fun createFluxDomainDog(): Flux<Dog> = Flux.fromArray(arrayOf(createDomainDog()))
fun createDomainDog() = Dog(id, name, breed, createDomainShelter())
fun createDomainShelter() = Shelter(idShelter)