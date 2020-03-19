package com.yorkismine.noname

import com.yorkismine.noname.data.Note

interface MainContract {
    interface View {
        fun showError()
        fun showResult(list: List<Note>)
    }

    interface Presenter {
        fun insert(note: Note)
        fun getAllNotes(): List<Note>
    }
}