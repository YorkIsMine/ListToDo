package com.yorkismine.noname.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.lang.Exception

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile private var instance: NotesDatabase? = null

        fun init(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, NotesDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            } else throw Exception("Database already initialized")
        }

        private const val DATABASE_NAME = "notes_database"

        @Synchronized
        fun getInstance(): NotesDatabase {
            if (instance != null) return instance!!
            else throw Exception("Database already initialized")
        }
    }
}