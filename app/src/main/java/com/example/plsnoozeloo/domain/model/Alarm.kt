package com.example.plsnoozeloo.domain.model

data class Alarm(
    val id: Int = 0,
    val title: String,
    var time: Long,
    var isEnabled: Boolean
)
