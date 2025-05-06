package com.example.plsnoozeloo.domain.repository

import com.example.plsnoozeloo.domain.model.Alarm

interface AlarmRepository {
    suspend fun getAlarms(): List<Alarm>
    suspend fun getAlarmById(id: Int) : Alarm?
    suspend fun insertAlarm(alarm: Alarm)
    suspend fun deleteAlarm(alarm: Alarm)
}