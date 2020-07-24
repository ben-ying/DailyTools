package com.yjh.dt.dailytools.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.http.GET

@Entity(tableName = "user_entity")
data class Currency (
    @PrimaryKey
    val code: String,
    val name: String,
    val sequence: Int
)


