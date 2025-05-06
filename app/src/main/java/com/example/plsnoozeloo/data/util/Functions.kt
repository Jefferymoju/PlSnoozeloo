package com.example.plsnoozeloo.data.util

import com.example.plsnoozeloo.data.local.AlarmEntity
import com.example.plsnoozeloo.domain.model.Alarm

fun AlarmEntity.toAlarm() : Alarm{
    return Alarm(
        id = id,
        title = title,
        time = time,
        isEnabled = isEnabled
    )
}

fun Alarm.toEntity(): AlarmEntity{
    return AlarmEntity(
        id = id,
        title = title,
        time = time,
        isEnabled = isEnabled
    )
}