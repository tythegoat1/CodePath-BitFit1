package com.example.codepath_bitfit

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import java.util.*
import kotlin.collections.ArrayList


class EntryActivity : AppCompatActivity() {



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.entry_activity)

        //Slider
        val sliderNum = findViewById<Slider>(R.id.slider)

        //EditText
        val feelingText = findViewById<EditText>(R.id.whyFeelings).text

        //Buttons
        val backButton = findViewById<Button>(R.id.entryBackButton)
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

    fun onSubmit(v: View) {
        val et = findViewById<View>(R.id.textToEdit) as EditText
        // Prepare data intent
        val data = Intent()
        // Pass relevant data back as a result
        data.putExtra("newString", et.text.toString())
        // Activity finished ok, return the data
        setResult(RESULT_OK, data) // set result code and bundle data for response
        finish() // closes the activity, pass data to parent
    }
}
