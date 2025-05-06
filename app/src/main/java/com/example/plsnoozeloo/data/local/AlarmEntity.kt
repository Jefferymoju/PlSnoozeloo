package com.example.plsnoozeloo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarms")
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title: String,
    var time: Long,
    var isEnabled: Boolean
)
