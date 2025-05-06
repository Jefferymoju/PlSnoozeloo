package com.example.plsnoozeloo.domain.use_cases

import com.example.plsnoozeloo.domain.model.Alarm
import com.example.plsnoozeloo.domain.repository.AlarmRepository

class DeleteAlarmUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke (alarm: Alarm): Result<Unit> {
        return try {
            repository.deleteAlarm(alarm)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}