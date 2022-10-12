package com.example.codepath_bitfit

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EntryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry_activity)

        val returnButton = findViewById<Button>(R.id.entryBackButton)
        returnButton.setOnClickListener() {
            this.finish()
        }
    }
}