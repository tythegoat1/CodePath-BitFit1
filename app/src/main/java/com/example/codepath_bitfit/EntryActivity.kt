package com.example.codepath_bitfit

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import java.util.*


class EntryActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry_activity)

        val backButton = findViewById<Button>(R.id.entryBackButton)
        val sliderNum = findViewById<Slider>(R.id.slider)
        val feelingText = findViewById<EditText>(R.id.whyFeelings).text.toString()
        val postButton = findViewById<Button>(R.id.entryPostButton)

        //Setting current date
        val textView: TextView = findViewById(R.id.dateTextView)
        val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy")
        val currentDate: String = simpleDateFormat.format(Date())
        textView.text = currentDate

        //Getting slider value
        sliderNum.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being started
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped
                Toast.makeText(
                    applicationContext,
                    "${sliderNum.value}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        //Handling post click event
        postButton.setOnClickListener {
            Toast.makeText(
                applicationContext,
                feelingText,
                Toast.LENGTH_SHORT
            ).show()
        }



        //Handling back click event
        backButton.setOnClickListener { finish() }
    }
}
