package com.example.codepath_bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider


class EntryAdapter(private var dailyEntryEntity: List<DailyEntryEntity>) :
    RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {


    inner class EntryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var date = v.findViewById<TextView>(R.id.dateTextView).toString()
        var entryNote = v.findViewById<TextView>(R.id.entryNoteNotes)
        var entryScale = v.findViewById<Slider>(R.id.entryNoteScale).value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.daily_entry_card, parent, false)
        return EntryViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dailyEntryEntity.size
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val newEntry = dailyEntryEntity[position]
        holder.date = newEntry.date.toString()
        holder.entryScale = newEntry.emotionalScale
        holder.entryNote.text = newEntry.emotionalNote
    }

}