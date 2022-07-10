package com.mobile.jetnoteapp.repository

import com.mobile.jetnoteapp.data.NoteDAO
import com.mobile.jetnoteapp.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDAO: NoteDAO) {

    suspend fun addNote(note: Note) = noteDAO.insertNote(note)
    suspend fun updateNote(note: Note) = noteDAO.updateNote(note)
    suspend fun deleteNote(note: Note) = noteDAO.deleteNote(note)
    suspend fun deleteAllNote() = noteDAO.deleteAllNotes()
    suspend fun getNoteByID(id: Int) = noteDAO.getNoteByID(id)
    fun getAllNotes() = noteDAO.getAllNotes().flowOn(Dispatchers.IO).conflate()

}