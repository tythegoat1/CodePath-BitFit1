package com.example.codepath_bitfit

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider

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
        entryAdapter = EntryAdapter(this, entryList)

        //Recycler view adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = entryAdapter



        var editActivityResultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            // If the user comes back to this activity from EditActivity
            // with no error or cancellation
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                // Get the data passed from EditActivity
                if (data != null) {
                    val editedString = data.extras!!.getString("newString")
                }
            }
        }

        btn.setOnClickListener {
            val intent = Intent(this, EntryActivity::class.java)
            editActivityResultLauncher.launch(intent)
        }


    }

}