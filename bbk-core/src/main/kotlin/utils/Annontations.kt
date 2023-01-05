package com.elouyi.bbk.utils

@RequiresOptIn(
    message = "This API is used for internal purposes only. It may be changed or removed at any time.",
    level = RequiresOptIn.Level.WARNING
)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
public annotation class BBKInternalAPI

@RequiresOptIn(
    message = "This API is experimental and may be changed or removed at any time.",
    level = RequiresOptIn.Level.WARNING
)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
public annotation class BBKExperimentalAPI

@DslMarker
public annotation class BBKDsl
