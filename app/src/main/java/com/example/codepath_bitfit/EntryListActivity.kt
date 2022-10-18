package com.example.codepath_bitfit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class EntryListActivity : AppCompatActivity() {
    lateinit var entries: ArrayList<EntryData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val rvEntity = findViewById<View>(R.id.recyclerView)
//        (ArrayList(EntryData)).also { entries = it }
//        val adapter = EntryAdapter(entries)
//        rvEntity.adapter = adapter
//
//        rvEntity.layoutManager = LinearLayoutManager(this)

    }
}