package com.yorkismine.noname

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yorkismine.noname.data.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    private lateinit var notes: List<Note>

    fun setData(data: List<Note>) {
        Log.d("TESTING", "setData()")
        notes = data
        Log.d("TESTING", "${notes.size}")
        notifyDataSetChanged()
    }

    class NotesHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = view.findViewById(R.id.title)
        private val descriptionTextView: TextView = view.findViewById(R.id.description)

        fun bind(note: Note) {
            titleTextView.text = note.title
            descriptionTextView.text = note.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return NotesHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("TESTING", "getItemCount() => value -> ${notes.size}")

        return notes.size
    }
        override fun onBindViewHolder(holder: NotesHolder, position: Int) {
            holder.bind(notes[position])
        }
    }
