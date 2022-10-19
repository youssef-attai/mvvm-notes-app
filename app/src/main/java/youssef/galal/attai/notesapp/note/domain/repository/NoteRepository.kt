package youssef.galal.attai.notesapp.note.domain.repository

import kotlinx.coroutines.flow.Flow
import youssef.galal.attai.notesapp.note.domain.model.Note

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}