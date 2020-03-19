package com.yorkismine.noname

import android.app.Application
import com.yorkismine.noname.data.NotesDatabase

class NoNameApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        NotesDatabase.init(this)
    }
}