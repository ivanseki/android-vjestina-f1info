package com.example.android_vjestina_f1info.ui.driverStandings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_vjestina_f1info.data.repository.IF1InfoRepository
import com.example.android_vjestina_f1info.ui.driverStandings.mapper.IDriverStandingsMapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DriverStandingsViewModel(
    private val driversRepository: IF1InfoRepository,
    driverStandingsMapper: IDriverStandingsMapper
) : ViewModel() {
    val driverStandingsViewState: StateFlow<DriverStandingsViewState> =
        driversRepository
            .driverStandings()
            .map { drivers ->
                driverStandingsMapper.toDriverStandingsState(drivers)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = DriverStandingsViewState(emptyList())
            )
}