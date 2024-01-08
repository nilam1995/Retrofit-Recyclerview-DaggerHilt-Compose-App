package com.example.recyclerviewcomposeapp.db.daos

import android.content.Context
import androidx.room.Room
import com.example.recyclerviewcomposeapp.db.AppDatabase
import com.example.recyclerviewcomposeapp.di.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext app:Context) = Room.databaseBuilder(app,
        AppDatabase::class.java,
        Constants.DATABASE_NAME).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideEmployeeDatabase(db:AppDatabase) = db.appDao()
}