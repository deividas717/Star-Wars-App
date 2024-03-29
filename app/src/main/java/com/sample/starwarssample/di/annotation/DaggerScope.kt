package com.sample.starwarssample.di.annotation

import androidx.lifecycle.LifecycleOwner
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS
)
annotation class DaggerScope(val value: KClass<out LifecycleOwner>)