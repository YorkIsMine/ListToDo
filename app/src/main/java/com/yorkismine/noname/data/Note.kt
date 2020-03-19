package com.yorkismine.noname.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String
)