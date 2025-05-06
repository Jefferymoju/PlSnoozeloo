package com.example.plsnoozeloo.domain.use_cases

import com.example.plsnoozeloo.domain.model.Alarm
import com.example.plsnoozeloo.domain.repository.AlarmRepository

class GetAlarmByIdUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke(id: Int): Alarm? {
        return repository.getAlarmById(id)
    }
}