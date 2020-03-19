package com.yorkismine.noname

import com.yorkismine.noname.data.Note

class MainViewModel {
    private val presenter: MainContract.Presenter = MainPresenter()

    val list: List<Note> = presenter.getAllNotes()

    fun insert(note: Note) {
        presenter.insert(note)
    }
}