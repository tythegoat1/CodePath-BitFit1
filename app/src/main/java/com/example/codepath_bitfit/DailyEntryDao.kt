
package com.example.codepath_bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DailyEntryDao {
    @Query("SELECT * FROM entry_table")
    fun getAll(): List<DailyEntryEntity>

    @Insert
    fun insert(daily_entry: DailyEntryEntity)

}