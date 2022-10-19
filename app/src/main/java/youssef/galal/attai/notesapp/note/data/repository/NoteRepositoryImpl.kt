package youssef.galal.attai.notesapp.note.data.repository

import kotlinx.coroutines.flow.Flow
import youssef.galal.attai.notesapp.note.data.datasource.NoteDao
import youssef.galal.attai.notesapp.note.domain.model.Note
import youssef.galal.attai.notesapp.note.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}