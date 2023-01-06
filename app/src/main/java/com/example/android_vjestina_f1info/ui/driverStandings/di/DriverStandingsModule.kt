package com.example.android_vjestina_f1info.ui.driverStandings.di

import com.example.android_vjestina_f1info.ui.driverStandings.DriverStandingsViewModel
import com.example.android_vjestina_f1info.ui.driverStandings.mapper.DriverStandingsMapper
import com.example.android_vjestina_f1info.ui.driverStandings.mapper.IDriverStandingsMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val driverStandingsModule = module {
    viewModel {
        DriverStandingsViewModel(
            driversRepository = get(),
            driverStandingsMapper = get()
        )
    }
    single<IDriverStandingsMapper> { DriverStandingsMapper() }
}