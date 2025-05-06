package com.example.plsnoozeloo.domain.use_cases

import com.example.plsnoozeloo.domain.model.Alarm
import com.example.plsnoozeloo.domain.repository.AlarmRepository

class ToggleAlarmUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke (alarm: Alarm): Result<Unit> {
        val updatedAlarm = alarm.copy(isEnabled = !alarm.isEnabled)

        return try {
            repository.insertAlarm(updatedAlarm)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}