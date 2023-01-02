package com.example.android_vjestina_f1info.model

data class Team(
    val id: Int,
    val name: String,
    val logoUrl: String?,
    val isFavorite: Boolean,
    val points: Int,
    val position: Int
)
