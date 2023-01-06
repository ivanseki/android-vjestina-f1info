package com.example.android_vjestina_f1info.data.di

import com.example.android_vjestina_f1info.data.repository.F1InfoRepository
import com.example.android_vjestina_f1info.data.repository.FakeF1InfoRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single<F1InfoRepository> {
        FakeF1InfoRepository(ioDispatcher = Dispatchers.IO)
    }
}