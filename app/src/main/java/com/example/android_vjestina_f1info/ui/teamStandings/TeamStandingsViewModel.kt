package com.example.android_vjestina_f1info.ui.teamStandings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_vjestina_f1info.data.repository.IF1InfoRepository
import com.example.android_vjestina_f1info.ui.teamStandings.mapper.ITeamStandingsMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class TeamStandingsViewModel(
    private val teamsRepository: IF1InfoRepository,
    teamStandingsMapper: ITeamStandingsMapper
) : ViewModel() {
    val teamStandingsViewState: StateFlow<TeamStandingsViewState> =
        teamsRepository
            .teamStandings()
            .map { teams ->
                teamStandingsMapper.toTeamStandingsState(teams)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = TeamStandingsViewState(emptyList())
            )
}