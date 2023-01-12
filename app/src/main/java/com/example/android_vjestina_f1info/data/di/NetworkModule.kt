package com.example.android_vjestina_f1info.data.di

import com.example.android_vjestina_f1info.data.network.F1InfoService
import com.example.android_vjestina_f1info.data.network.IF1InfoService
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single<IF1InfoService> { F1InfoService(client = get()) }
/*
    install(DefaultHeaders) {
        header("X-RapidAPI-Key", "7cc27589a7mshcb29eacccff6aeap186cd5jsn016ceaf74ef5")
        header("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com")
    }
*/
    single {
        HttpClient(Android) {
            expectSuccess = true

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }

            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            install(DefaultRequest) {
                header("X-RapidAPI-Key", "7cc27589a7mshcb29eacccff6aeap186cd5jsn016ceaf74ef5")
                header("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com")
            }
        }
    }
}