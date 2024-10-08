package com.adjust.utils

import android.app.Application
import android.content.Context

actual object AppContext {
    private lateinit var application: Application

    fun setUp(context: Context) {
        application = context as Application
    }

    fun get(): Context {
        if (::application.isInitialized.not()) throw Exception("Application Context not initialized")
        return application.applicationContext
    }
}