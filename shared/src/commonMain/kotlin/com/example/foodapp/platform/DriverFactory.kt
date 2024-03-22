package com.example.foodapp.platform

import app.cash.sqldelight.db.SqlDriver
import com.example.Database

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database {
    val driver = driverFactory.createDriver()
    return Database(driver)
}