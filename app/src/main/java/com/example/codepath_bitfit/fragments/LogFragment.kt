package com.example.codepath_bitfit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.codepath_bitfit.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogFragment : Fragment() {

    lateinit var entries : List<DailyEntryEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_log, container, false)

        val logRecyclerView = view.findViewById<View>(R.id.logRecyclerView)

        //Get data from database
        val data = lifecycleScope.launch(Dispatchers.IO) {
            (activity?.application as DailyEntryApplication).db.dailyEntryDao().getAll()
        }


        return view
    }

}