package com.example.plsnoozeloo.domain.use_cases

import com.example.plsnoozeloo.domain.model.Alarm
import com.example.plsnoozeloo.domain.repository.AlarmRepository

class AddAlarmUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke (alarm: Alarm): Result<Unit> {
        if (alarm.title.isBlank()) {
            return Result.failure(IllegalArgumentException("Name cannot be empty"))
        }

        return try {
            repository.insertAlarm(alarm)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}