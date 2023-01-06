package com.example.android_vjestina_f1info.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_vjestina_f1info.data.repository.F1InfoRepository
import com.example.android_vjestina_f1info.ui.home.mapper.IHomeScreenMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val teamsRepository: F1InfoRepository,
    homeMapper: IHomeScreenMapper
) : ViewModel() {
    val teamsViewState: StateFlow<HomeViewState> =
        teamsRepository
            .teams()
            .map { teams ->
                homeMapper.toHomeViewState(teams)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = HomeViewState(emptyList())
            )

    fun toggleFavorite(teamId: Int) {
        viewModelScope.launch {
            teamsRepository.toggleFavorite(teamId)
        }
    }
}