package com.example.android_vjestina_f1info.ui.home.di

import com.example.android_vjestina_f1info.ui.home.HomeViewModel
import com.example.android_vjestina_f1info.ui.home.mapper.HomeScreenMapper
import com.example.android_vjestina_f1info.ui.home.mapper.IHomeScreenMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(
            teamsRepository = get(),
            homeMapper = get()
        )
    }
    single<IHomeScreenMapper> { HomeScreenMapper() }
}