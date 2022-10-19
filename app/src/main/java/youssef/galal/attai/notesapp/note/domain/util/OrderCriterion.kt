package youssef.galal.attai.notesapp.note.domain.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import youssef.galal.attai.notesapp.note.domain.model.Note


sealed class OrderCriterion(private val orderType: OrderType) {
    abstract fun ordered(notesCollection: Flow<List<Note>>): Flow<List<Note>>

    class Title(private val orderType: OrderType) : OrderCriterion(orderType) {
        override fun ordered(notesCollection: Flow<List<Note>>): Flow<List<Note>> {
            return notesCollection.map { notes ->
                orderType.sorted(notes) { it.title.lowercase() }
            }
        }
    }

    class Date(private val orderType: OrderType) : OrderCriterion(orderType) {
        override fun ordered(notesCollection: Flow<List<Note>>): Flow<List<Note>> {
            return notesCollection.map { notes ->
                orderType.sorted(notes) { it.timestamp }
            }
        }
    }

    class Color(private val orderType: OrderType) : OrderCriterion(orderType) {
        override fun ordered(notesCollection: Flow<List<Note>>): Flow<List<Note>> {
            return notesCollection.map { notes ->
                orderType.sorted(notes) { it.color }
            }
        }
    }
}
