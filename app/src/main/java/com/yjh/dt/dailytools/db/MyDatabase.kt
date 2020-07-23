package com.yjh.dt.dailytools.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yjh.dt.dailytools.model.Currency

@Database(entities = [Currency::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}