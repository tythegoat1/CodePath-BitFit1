package com.example.codepath_bitfit

import android.app.Application

class DailyEntryApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}