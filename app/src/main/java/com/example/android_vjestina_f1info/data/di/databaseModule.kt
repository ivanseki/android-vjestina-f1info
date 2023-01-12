package com.example.android_vjestina_f1info.data.di

import androidx.room.Room
import com.example.android_vjestina_f1info.data.database.F1InfoAppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val APP_DATABASE_NAME = "app_database.db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            F1InfoAppDatabase::class.java,
            APP_DATABASE_NAME,
        ).build()
    }
}