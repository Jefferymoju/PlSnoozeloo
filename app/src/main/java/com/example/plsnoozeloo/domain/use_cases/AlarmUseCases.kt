package com.example.plsnoozeloo.domain.use_cases

data class AlarmUseCases(
    val getAlarms: GetAlarmUseCase,
    val getAlarmById: GetAlarmByIdUseCase,
    val addAlarm: AddAlarmUseCase,
    val toggleAlarm: ToggleAlarmUseCase,
    val deleteAlarm: DeleteAlarmUseCase
)
