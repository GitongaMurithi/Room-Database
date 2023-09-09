package com.example.login.di

import android.app.Application
import androidx.room.Room
import com.example.login.data.UserDatabase
import com.example.login.repository.UserRepository
import com.example.login.repository.UserRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application) : UserDatabase{
        return Room.databaseBuilder(
            application,
            UserDatabase::class.java,
            "user_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesRepository(database: UserDatabase) : UserRepository {
        return UserRepositoryImplementation(database.dao)
    }
}