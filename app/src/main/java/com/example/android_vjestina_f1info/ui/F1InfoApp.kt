package com.example.android_vjestina_f1info.ui

import android.app.Application
import com.example.android_vjestina_f1info.data.di.dataModule
import com.example.android_vjestina_f1info.ui.driverStandings.di.driverStandingsModule
import com.example.android_vjestina_f1info.ui.home.di.homeModule
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.di.teamDetailsModule
import com.example.android_vjestina_f1info.ui.teamStandings.di.teamStandingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class F1InfoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(androidContext = this@F1InfoApp)
            modules(
                dataModule,
                teamStandingsModule,
                driverStandingsModule,
                teamDetailsModule,
                homeModule
            )
        }
    }
}