package youssef.galal.attai.notesapp.note.domain.usecase

import kotlinx.coroutines.flow.Flow
import youssef.galal.attai.notesapp.note.domain.model.Note
import youssef.galal.attai.notesapp.note.domain.repository.NoteRepository
import youssef.galal.attai.notesapp.note.domain.util.OrderCriterion
import youssef.galal.attai.notesapp.note.domain.util.OrderType

class GetAllNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(
        orderCriterion: OrderCriterion = OrderCriterion.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return orderCriterion.ordered(repository.getAllNotes())
    }
}