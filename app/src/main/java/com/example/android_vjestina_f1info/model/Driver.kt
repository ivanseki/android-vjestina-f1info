package com.example.android_vjestina_f1info.model

data class Driver(
    val id: Int,
    val name: String,
    val number: Int,
    val imageUrl: String?,
    val points: Int,
    val position: Int,
    val countryName: String
)
