package com.example.codepath_bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entry_table")
data class DailyEntry (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "emotion") val emotionRadioBTN: String?,
    @ColumnInfo(name = "emotionalScale") val emotionalScale: String?,
    @ColumnInfo(name = "emotionalNotes") val emotionalNotes: String?
)