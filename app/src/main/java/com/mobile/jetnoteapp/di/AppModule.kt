package com.mobile.jetnoteapp.di

import android.content.Context
import androidx.room.Room
import com.mobile.jetnoteapp.data.NoteDAO
import com.mobile.jetnoteapp.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDAO(noteDatabase: NoteDatabase): NoteDAO =
        noteDatabase.noteDAO()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "notes_db"
        ).fallbackToDestructiveMigration().build()


}