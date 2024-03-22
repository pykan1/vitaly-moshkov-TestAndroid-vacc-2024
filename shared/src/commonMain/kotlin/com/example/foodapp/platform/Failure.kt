package com.example.foodapp.platform

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [Failure] class.
 */
sealed class Failure(override val message: String) : Throwable() {
    class Http(val code: Int, override val message: String) : Failure(message)
    class Message(message: String) : Failure(message)
    object InternetConnection : Failure("Нет подключения к интернету")

}