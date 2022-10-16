package com.example.codepath_bitfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.addNoteButton)

        btn.setOnClickListener {
            val i = Intent(this@MainActivity, EntryActivity::class.java)
            startActivity(i)
        }

    }

}