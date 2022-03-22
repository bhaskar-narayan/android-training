package com.carmedia2p0.capture.model

/**
 * Represents a network bound resource. Each subclass represents the resource's   state:
 * - [Loading]: the resource is being retrieved from network.
 * - [Success]: the resource has been retrieved (available in [Success.data] field)
 * - [Failure]: the resource retrieving has failed (throwable available in [Failure.throwable]
 * field)
 */
sealed class Outcome<out T> {
    class Loading<out T> : Outcome<T>()
    data class Success<out T>(val data: T) : Outcome<T>()
    data class Failure<out T>(val throwable: Throwable) : Outcome<T>()
}
