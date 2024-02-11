package com.example.foodapp.root.platform

inline fun <reified T : Any?, reified R : Any> apiCall(
    call: () -> T,
    mapResponse: (T) -> R,
): Either<Failure, R> =
    try {
        Either.Right(mapResponse(call.invoke()))
    } catch (ex: Failure) {
        Either.Left(ex)
    }

inline fun <reified T : Any> apiCall(
    call: () -> T,
): Either<Failure, T> =
    try {
        Either.Right(call.invoke())
    } catch (ex: Failure) {
        Either.Left(ex)
    }