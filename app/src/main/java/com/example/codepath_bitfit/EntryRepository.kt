package com.example.codepath_bitfit

import androidx.lifecycle.LiveData

class EntryRepository (private val entryDao: DailyEntryDao){

    val readAllData : LiveData<List<DailyEntryEntity>> = entryDao.getAll()
}