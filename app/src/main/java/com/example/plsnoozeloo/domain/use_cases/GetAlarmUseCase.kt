package com.example.plsnoozeloo.domain.use_cases

import com.example.plsnoozeloo.domain.model.Alarm
import com.example.plsnoozeloo.domain.repository.AlarmRepository

class GetAlarmUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke(): List<Alarm> {
        return repository.getAlarms()
    }
}