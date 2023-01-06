package com.example.android_vjestina_f1info.mock

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object FavoritesDBMock {
    private val favoritesIdsState = MutableStateFlow(setOf<Int>())
    val favoriteIds: StateFlow<Set<Int>> = favoritesIdsState.asStateFlow()
    fun insert(teamId: Int) = favoritesIdsState.update { it + teamId }
    fun delete(teamId: Int) = favoritesIdsState.update { it - teamId }
}