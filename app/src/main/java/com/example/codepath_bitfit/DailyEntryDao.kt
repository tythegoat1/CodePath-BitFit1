
package com.example.codepath_bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DailyEntryDao {
    @Query("SELECT * FROM entry_table")
    fun getAll(): LiveData<List<DailyEntryEntity>>

    @Insert
    fun insert(daily_entry: DailyEntryEntity)

}