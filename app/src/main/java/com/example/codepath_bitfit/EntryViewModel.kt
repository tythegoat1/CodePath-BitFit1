package com.example.codepath_bitfit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class EntryViewModel (application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<DailyEntryEntity>>
    private val repo : EntryRepository

    init {
        val entryDao = AppDatabase.buildDatabase(application).dailyEntryDao()
        repo = EntryRepository(entryDao)
        readAllData = repo.readAllData
    }
}