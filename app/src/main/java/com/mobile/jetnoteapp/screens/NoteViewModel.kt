package com.mobile.jetnoteapp.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.jetnoteapp.models.Note
import com.mobile.jetnoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@RequiresApi(Build.VERSION_CODES.O)
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
    private var _noteList = MutableStateFlow<List<Note>>(emptyList())
    var noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isNotEmpty()) {
                    _noteList.value = listOfNotes
                }
            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { noteRepository.addNote(note) }
    fun removeNote(note: Note) = viewModelScope.launch { noteRepository.deleteNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { noteRepository.updateNote(note) }
    fun getNoteByID(id: Int) = viewModelScope.launch { noteRepository.getNoteByID(id) }
    fun deleteAllNotes() = viewModelScope.launch { noteRepository.deleteAllNote() }
}