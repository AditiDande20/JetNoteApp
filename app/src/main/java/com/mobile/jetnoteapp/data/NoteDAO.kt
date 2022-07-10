package com.mobile.jetnoteapp.data

import androidx.room.*
import com.mobile.jetnoteapp.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Query("select * from notes_tbl")
    fun getAllNotes(): Flow<List<Note>>

    @Query("select * from notes_tbl where id=:id")
    suspend fun getNoteByID(id: Int): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("delete from notes_tbl")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)
}