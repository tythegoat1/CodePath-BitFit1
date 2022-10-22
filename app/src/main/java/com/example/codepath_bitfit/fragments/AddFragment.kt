package com.example.codepath_bitfit.fragments


import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.codepath_bitfit.DailyEntryApplication
import com.example.codepath_bitfit.DailyEntryEntity
import com.example.codepath_bitfit.R
import com.google.android.material.slider.Slider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class AddFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        //Slider
        val sliderNum = view.findViewById<Slider>(R.id.slider)

        //EditText
        val feelingText = view.findViewById<EditText>(R.id.whyFeelings).text

        //Buttons
        val postButton = view.findViewById<Button>(R.id.entryPostButton)

        //Setting current date
        val textView: TextView = view.findViewById(R.id.dateTextView)
        val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy")
        val currentDate = simpleDateFormat.format(Date())
        currentDate.also { textView.text = it }

        //Getting slider value
        sliderNum.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being started
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped

            }
        })

        //Handling post click event
        postButton.setOnClickListener {
            Toast.makeText(context, "Added to Database", Toast.LENGTH_SHORT).show()

            // TODO Save event to database
            lifecycleScope.launch(Dispatchers.IO) {
                (activity?.application as DailyEntryApplication).db.dailyEntryDao().insert(
                    DailyEntryEntity(
                        currentDate,
                        sliderNum.value,
                        feelingText.toString()
                    )
                )

            }
            // Empty text fields
            view.findViewById<EditText>(R.id.whyFeelings).setText("")
        }
        return view
    }
}