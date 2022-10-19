package youssef.galal.attai.notesapp.note.domain.usecase

import youssef.galal.attai.notesapp.note.domain.model.Note
import youssef.galal.attai.notesapp.note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}