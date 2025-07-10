package com.openclassrooms.notes.ViewModel

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.data.Notes
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteViewModel( private val notesRepository: NotesRepository = NotesRepository()  ): ViewModel() {
    private val _notes: MutableStateFlow<List<Notes>> = MutableStateFlow(emptyList())//permet de stocker la liste de notes
    val notes: Flow<List<Notes>> = _notes.asStateFlow()//permet de ne pas modifier la liste de notes
    init {
        viewModelScope.launch {//permet de lancer une coroutine dans le viewModel
            notesRepository.notes.collect { //permet de collecter les modifications de la liste de notes
                _notes.value = it //met à jour la liste de notes
            }
        }
    }

}