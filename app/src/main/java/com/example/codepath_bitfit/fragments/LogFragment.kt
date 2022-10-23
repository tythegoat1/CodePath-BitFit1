package com.example.codepath_bitfit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codepath_bitfit.*

class LogFragment : Fragment() {
    private lateinit var entryViewModel: EntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_log, container, false)

        val adapter = EntryAdapter()
        val logRecyclerView = view.findViewById<RecyclerView>(R.id.logRecyclerView)
        logRecyclerView.adapter = adapter
        logRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        entryViewModel = ViewModelProvider(this).get(EntryViewModel::class.java)
        entryViewModel.readAllData.observe(viewLifecycleOwner, Observer { entry ->
            adapter.setData(entry)
        })

        return view
    }

}