package com.yjh.dt.dailytools.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_entity")
data class Currency (
    @PrimaryKey
    private val code: String,
    private val name: String,
    private val sequence: Int
)

