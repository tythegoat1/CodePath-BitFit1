package com.example.codepath_bitfit

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import java.util.*


class EntryAdapter() :
    RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    private var entryList = emptyList<DailyEntryEntity>()

    @RequiresApi(Build.VERSION_CODES.N)
    val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy")
    @RequiresApi(Build.VERSION_CODES.N)
    val currentDate = simpleDateFormat.format(Date())

    class EntryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var date = v.findViewById<TextView>(R.id.entryNoteDate)
        //var entryNoteScale = v.findViewById<Slider>(R.id.entryNoteScale).value
        var entryNoteNotes = v.findViewById<TextView>(R.id.entryNoteNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.daily_entry_card, parent, false)
        return EntryViewHolder(v)
    }

    override fun getItemCount(): Int {
        return entryList.size
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val newEntry = entryList[position]
        holder.date.setText(currentDate)
        //holder.entryNoteScale = newEntry.emotionalScale
        holder.entryNoteNotes.text = newEntry.emotionalNote
    }

    fun setData ( entry : List<DailyEntryEntity>) {
        this.entryList = entry
        notifyDataSetChanged()
    }

}