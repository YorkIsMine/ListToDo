package com.yorkismine.noname

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yorkismine.noname.data.Note
import com.yorkismine.noname.data.NotesDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel()
        adapter = NotesAdapter()
        adapter.setData(viewModel.list)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter


        fab.setOnClickListener {
            val note = Note(null, "this is title", "Desc!")
            viewModel.insert(note)
        }

    }
}
