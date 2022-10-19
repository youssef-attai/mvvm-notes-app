package youssef.galal.attai.notesapp.note.data.datasource

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import youssef.galal.attai.notesapp.note.domain.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note;")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id;")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}