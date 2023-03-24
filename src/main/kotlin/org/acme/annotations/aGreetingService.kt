package org.acme.annotations

import javax.inject.Qualifier;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
annotation class StandardGreeting {};

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
annotation class CasualGreeting{}