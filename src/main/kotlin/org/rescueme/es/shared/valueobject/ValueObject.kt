package org.rescueme.es.shared.valueobject

import javax.persistence.Embeddable

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Embeddable
annotation class ValueObject