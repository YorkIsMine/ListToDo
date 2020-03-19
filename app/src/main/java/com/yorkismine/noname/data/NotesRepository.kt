package com.yorkismine.noname.data

import io.reactivex.Single

class NotesRepository private constructor(private val noteDao: NoteDao) {
    fun getAllNotes(): Single<List<Note>> {
        return noteDao.getAllNotes()
    }

    fun getNoteById(id: Long): Single<Note> {
        return noteDao.getNoteById(id)
    }

    fun insert(note: Note) {
        noteDao.insert(note)
    }

    companion object {
        @Volatile private var instance: NotesRepository? = null

        fun getInstance(noteDao: NoteDao): NotesRepository {
            return instance ?: synchronized(this) {
                instance ?: NotesRepository(noteDao).also { instance = it }
            }
        }
    }
}