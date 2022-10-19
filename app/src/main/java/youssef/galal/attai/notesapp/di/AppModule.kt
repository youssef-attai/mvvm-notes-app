package youssef.galal.attai.notesapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import youssef.galal.attai.notesapp.note.data.datasource.NoteDatabase
import youssef.galal.attai.notesapp.note.data.repository.NoteRepositoryImpl
import youssef.galal.attai.notesapp.note.domain.repository.NoteRepository
import youssef.galal.attai.notesapp.note.domain.usecase.DeleteNote
import youssef.galal.attai.notesapp.note.domain.usecase.GetAllNotes
import youssef.galal.attai.notesapp.note.domain.usecase.NoteUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getAllNotes = GetAllNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}