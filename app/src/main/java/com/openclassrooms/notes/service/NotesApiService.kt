package com.openclassrooms.notes.service

import com.openclassrooms.notes.data.Notes

/**
 * Defines the contract for the API that manages the notes
 */
interface NotesApiService {

    /**
     * Add a note
     * @param note The note to add
     */
    fun addNote(note: Notes)

    /**
     * Returns all the notes
     * @return the list of notes
     */
    fun getAllNotes(): List<Notes>

}