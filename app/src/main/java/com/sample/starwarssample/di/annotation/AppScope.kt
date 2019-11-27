package com.sample.starwarssample.di.annotation

import javax.inject.Scope

/**
 * Defines singleton scope. Instances marked with this annotation has the same lifetime <br/>
 * as an Application.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope