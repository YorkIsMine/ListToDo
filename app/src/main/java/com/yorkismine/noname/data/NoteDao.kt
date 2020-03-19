package com.yorkismine.noname.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes(): Single<List<Note>>

    @Query("SELECT * FROM notes_table WHERE id = :id")
    fun getNoteById(id: Long): Single<Note>
}