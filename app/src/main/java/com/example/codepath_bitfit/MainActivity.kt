package com.example.codepath_bitfit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var entryList: ArrayList<EntryData>
    private lateinit var entryAdapter: EntryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //RecyclerView
        recyclerView = findViewById(R.id.recyclerView)

        //Button
        val btn = findViewById<Button>(R.id.addNoteButton)

        //Setting List
        entryList = ArrayList()

        //Setting Adapter
        entryAdapter = EntryAdapter(entryList)

        //Recycler view adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = entryAdapter



        btn.setOnClickListener {
            val i = Intent(this, EntryActivity::class.java)
            startActivity(i) // brings up the second activity
        }


    }

}