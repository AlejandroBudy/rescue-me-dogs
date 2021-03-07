package org.rescueme.es.shared.valueobject

import org.rescueme.es.shared.noargs.NoArgsConstructor
import javax.persistence.Embeddable

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Embeddable
@NoArgsConstructor
annotation class ValueObject