package com.example.android_vjestina_f1info.ui.teamDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_vjestina_f1info.data.repository.IF1InfoRepository
import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper.ITeamDetailsMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TeamDetailsViewModel(
    private val teamRepository: IF1InfoRepository,
    teamDetailsMapper: ITeamDetailsMapper,
    teamId: Int
) : ViewModel() {
    val teamDetailsViewState: StateFlow<TeamDetailsViewState> =
        teamRepository.teamDetails(teamId)
            .map { team -> teamDetailsMapper.toTeamDetailsViewState(team) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = TeamDetailsViewState(
                    team = Team(
                        id = 1,
                        name = "",
                        logoUrl = "",
                        isFavorite = false,
                    ),
                    drivers = emptyList(),
                    base = "",
                    first_team_entry = 0,
                    world_championships = 0,
                    pole_positions = 0,
                    fastest_laps = 0,
                    president = "",
                    director = "",
                    technical_manager = "",
                    chassis = "",
                    engine = ""
                )
            )

    fun toggleFavorite(teamId: Int) {
        viewModelScope.launch {
            teamRepository.toggleFavorite(teamId)
        }
    }
}