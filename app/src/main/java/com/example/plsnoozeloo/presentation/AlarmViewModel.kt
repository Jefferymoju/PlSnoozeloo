package com.example.plsnoozeloo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plsnoozeloo.domain.model.Alarm
import com.example.plsnoozeloo.domain.use_cases.AlarmUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AlarmUiState(
    val alarms: List<Alarm> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class AlarmViewModel(
    private val alarmUseCases: AlarmUseCases
): ViewModel(){
    private val _uiState = MutableStateFlow(AlarmUiState())
    val uiState: StateFlow<AlarmUiState> = _uiState.asStateFlow()

    init {
        loadAlarms()
    }

    fun loadAlarms(){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val alarms = alarmUseCases.getAlarms()
                _uiState.update { it.copy(alarms = alarms, isLoading = false, error = null) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun addAlarm(title: String, timeInMillis : Long) {
        viewModelScope.launch {
            val alarm = Alarm(
                title = title,
                time = timeInMillis,
                isEnabled = true
            )
            alarmUseCases.addAlarm(alarm)
                .onSuccess { loadAlarms() }
                .onFailure { e ->
                    _uiState.update { it.copy(error = e.message) }
                }
        }
    }

    fun deleteAlarm(alarm: Alarm) {
        viewModelScope.launch {
            alarmUseCases.deleteAlarm(alarm)
                .onSuccess { loadAlarms() }
                .onFailure { e ->
                    _uiState.update { it.copy(error = e.message) }
                }
        }
    }

    fun toggleAlarm(alarm: Alarm){
        viewModelScope.launch {
            alarmUseCases.toggleAlarm(alarm)
                .onSuccess { loadAlarms() }
                .onFailure { e ->
                    _uiState.update { it.copy(error = e.message) }
                }
        }
    }
}