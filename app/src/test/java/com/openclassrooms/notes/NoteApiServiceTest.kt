package com.openclassrooms.notes

import com.openclassrooms.notes.service.LocalNotesApiService
import com.openclassrooms.notes.service.NotesApiService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NoteApiServiceTest {

    /**
     *
     */
    private lateinit var localNotesApiService: NotesApiService
    @Before
    fun setUp() {
        localNotesApiService = LocalNotesApiService()
    }

    @Test
    fun countNotes_inLocalNotesApiService() {
        val countNotesLocalApiService =localNotesApiService.getAllNotes().size
        assertEquals(10, countNotesLocalApiService)
    }



}



