package com.openclassrooms.notes.repository

import com.openclassrooms.notes.data.Notes
import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Repository class for the notes.
 */
class NotesRepository {

    /**
     * The API service for interacting with notes.
     */
    private val notesApiService: NotesApiService = LocalNotesApiService()

    /**
     * A flow that emits a list of all notes.
     */
    val notes: Flow<List<Notes>> = flow {
        emit(notesApiService.getAllNotes())
    }
}