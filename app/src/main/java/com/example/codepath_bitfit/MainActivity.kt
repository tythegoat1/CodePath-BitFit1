package com.example.codepath_bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //addNote()
    }

    fun addNote(){
        val noteBTN = findViewById<Button>(R.id.addNoteButton)
        noteBTN.setOnClickListener() {
            val i = Intent(this, EntryActivity::class.java)
            startActivity(i)
        }

    }

}