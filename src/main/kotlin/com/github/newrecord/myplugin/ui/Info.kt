package com.github.newrecord.myplugin.ui

import org.jetbrains.annotations.ApiStatus

@ApiStatus.Internal
@Retention
@Target(AnnotationTarget.FUNCTION)
annotation class Info(val title: String, val description: String)
