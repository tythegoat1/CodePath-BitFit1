package com.example.codepath_bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyEntryDao {
    @Query("SELECT * FROM entry_table")
    fun getAll(): Flow<List<DailyEntryEntity>>

    @Insert
    fun insertAll(entry: List<DailyEntryEntity>)

    @Insert
    fun insert(daily_entry: DailyEntryEntity)

    @Query("DELETE FROM entry_table")
    fun deleteAll()
}