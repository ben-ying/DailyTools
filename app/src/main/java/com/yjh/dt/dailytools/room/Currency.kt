package com.yjh.dt.dailytools.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency (
    @PrimaryKey private val code: String,
    private val name: String,
    private val sequence: Int
)

