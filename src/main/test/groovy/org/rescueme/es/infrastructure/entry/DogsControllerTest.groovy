package org.rescueme.es.infrastructure.entry

import org.rescueme.es.domain.ports.inbound.DogRegister
import org.rescueme.es.domain.ports.inbound.DogRetriever
import reactor.test.StepVerifier
import spock.lang.Specification

class DogsControllerTest extends Specification {

    def dogRetriever = Mock(DogRetriever)
    def dogRegister = Mock(DogRegister)

    def controller = new DogsController(dogRetriever, dogRegister)

    def "Should get all dog from shelter ok"() {
        when:
        def actual = controller.getAllDogsInShelter(DogsControllerTestUtilsKt.idShelterEncoded)
        then:
        StepVerifier.create(actual.log())
                .expectNext(DogsControllerTestUtilsKt.createDogPayload())
                .verifyComplete()
        then:
        1 * dogRetriever.findAllDogsByShelter(DogsControllerTestUtilsKt.createDomainShelter()) >>
                DogsControllerTestUtilsKt.createFluxDomainDog()
    }
}
