package com.example.plsnoozeloo.domain.repository

import com.example.plsnoozeloo.data.local.AlarmDao
import com.example.plsnoozeloo.data.util.toAlarm
import com.example.plsnoozeloo.data.util.toEntity
import com.example.plsnoozeloo.domain.model.Alarm

class AlarmRepositoryImpl(
    private val dao: AlarmDao
): AlarmRepository {
    override suspend fun getAlarms(): List<Alarm> {
        return dao.getAlarms().map { it.toAlarm() }
    }

    override suspend fun getAlarmById(id: Int): Alarm? {
        return dao.getAlarmById(id)?.toAlarm()
    }

    override suspend fun insertAlarm(alarm: Alarm) {
        dao.insertAlarm(alarm.toEntity())
    }

    override suspend fun deleteAlarm(alarm: Alarm) {
        dao.deleteAlarm(alarm.toEntity())
    }
}