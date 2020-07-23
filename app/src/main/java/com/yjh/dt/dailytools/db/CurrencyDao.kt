package com.yjh.dt.dailytools.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yjh.dt.dailytools.model.Currency

@Dao
interface CurrencyDao {
    @Insert(onConflict = REPLACE)
    fun saveAll(Currencies: List<Currency>)

    @Query("SELECT * FROM user_entity ORDER BY sequence")
    fun loadAll(): LiveData<List<Currency>>
}