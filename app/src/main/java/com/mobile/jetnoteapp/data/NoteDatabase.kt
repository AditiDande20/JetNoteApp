package com.mobile.jetnoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobile.jetnoteapp.models.Note
import com.mobile.jetnoteapp.utils.IDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(IDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}