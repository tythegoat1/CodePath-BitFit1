package com.example.codepath_bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EntryAdapter(val entryList: ArrayList<EntryData>) :
    RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    inner class EntryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var entryNote = v.findViewById<EditText>(R.id.entryNoteNotes)
        var entryScale = v.findViewById<TextView>(R.id.entryNoteScale)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.daily_entry_card, parent, false)
        return EntryViewHolder(v)
    }

    override fun getItemCount(): Int {
        return entryList.size
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val newEntry = entryList[position]
        holder.entryScale = newEntry.scale
        holder.entryNote.text = newEntry.note
    }

}