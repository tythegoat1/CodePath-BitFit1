package com.example.codepath_bitfit


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entry_table")
data class DailyEntryEntity(
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "emotionalScale") val emotionalScale: Float,
    @ColumnInfo(name = "emotionalNotes") val emotionalNote: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)