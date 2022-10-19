package youssef.galal.attai.notesapp.note.domain.util

import youssef.galal.attai.notesapp.note.domain.model.Note

sealed class OrderType {
    abstract fun <T: Comparable<T>> sorted(notes: List<Note>, selector: (Note) -> T): List<Note>

    object Ascending : OrderType() {
        override fun <T: Comparable<T>> sorted(
            notes: List<Note>,
            selector: (Note) -> T
        ): List<Note> {
            return notes.sortedBy(selector)
        }
    }

    object Descending : OrderType() {
        override fun <T: Comparable<T>> sorted(
            notes: List<Note>,
            selector: (Note) -> T
        ): List<Note> {
            return notes.sortedByDescending(selector)
        }
    }
}
