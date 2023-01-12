package com.example.android_vjestina_f1info.data.di

import com.example.android_vjestina_f1info.data.repository.F1InfoRepository
import com.example.android_vjestina_f1info.data.repository.IF1InfoRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single<IF1InfoRepository> {
        F1InfoRepository(
            f1InfoService = get(),
            teamDao = get(),
            bgDispatcher = Dispatchers.IO
        )
    }
}