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

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        adapter = NotesAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        presenter.getAllNotes()
        fab.setOnClickListener {
            val note = Note(null, "this is title", "Desc!")
            presenter.insert(note)

            presenter.getAllNotes()

        }



    }

    override fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun showResult(list: List<Note>) {
        Log.d("TESTING", "showResult()")
        adapter.setData(list)
    }
}
