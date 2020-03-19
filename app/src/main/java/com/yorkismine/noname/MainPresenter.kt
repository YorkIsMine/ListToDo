package com.yorkismine.noname

import android.annotation.SuppressLint
import android.util.Log
import com.yorkismine.noname.data.Note
import com.yorkismine.noname.data.NoteDao
import com.yorkismine.noname.data.NotesDatabase
import com.yorkismine.noname.data.NotesRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlin.concurrent.thread

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    private val dao = NotesDatabase.getInstance().noteDao()
    private val repo = NotesRepository.getInstance(dao)

    @SuppressLint("CheckResult")
    override fun insert(note: Note) {
        Log.d("TESTING", "insert() -> MainPresenter")

        Single.just(note)
            .subscribeOn(Schedulers.io())
            .subscribe({ repo.insert(it) }, {})
    }

    @SuppressLint("CheckResult")
    override fun getAllNotes() {
        Log.d("TESTING", "getAllNotes() -> MainPresenter")

        repo.getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.showResult(it) }, { view.showError() })
    }


}