package com.example.plsnoozeloo.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlarmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarm(alarm:AlarmEntity)

    @Delete
    suspend fun deleteAlarm(alarm: AlarmEntity)

    @Query("SELECT * FROM alarms")
    suspend fun getAlarms() : List<AlarmEntity>

    @Query("SELECT * FROM alarms WHERE id = id")
    suspend fun getAlarmById(alarmId: Int): AlarmEntity?
}