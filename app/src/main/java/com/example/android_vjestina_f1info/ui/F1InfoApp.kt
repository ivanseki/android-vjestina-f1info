package com.example.android_vjestina_f1info.ui

import android.app.Application
import android.util.Log

class F1InfoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d("F1InfoApp", "App started")
    }
}