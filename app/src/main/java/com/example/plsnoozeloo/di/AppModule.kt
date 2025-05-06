package com.example.plsnoozeloo.di

import android.app.Application
import androidx.room.Room
import com.example.plsnoozeloo.data.local.AlarmDatabase
import com.example.plsnoozeloo.domain.repository.AlarmRepository
import com.example.plsnoozeloo.domain.repository.AlarmRepositoryImpl
import com.example.plsnoozeloo.domain.use_cases.AddAlarmUseCase
import com.example.plsnoozeloo.domain.use_cases.AlarmUseCases
import com.example.plsnoozeloo.domain.use_cases.DeleteAlarmUseCase
import com.example.plsnoozeloo.domain.use_cases.GetAlarmByIdUseCase
import com.example.plsnoozeloo.domain.use_cases.GetAlarmUseCase
import com.example.plsnoozeloo.domain.use_cases.ToggleAlarmUseCase
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
    fun provideAlarmDatabase(app: Application): AlarmDatabase {
        return Room.databaseBuilder(
            app,
            AlarmDatabase::class.java,
            "alarms"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAlarmRepository(db: AlarmDatabase): AlarmRepository {
        return AlarmRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideAlarmUseCases(repository: AlarmRepository): AlarmUseCases {
        return AlarmUseCases(
            getAlarms = GetAlarmUseCase(repository),
            getAlarmById = GetAlarmByIdUseCase(repository),
            addAlarm = AddAlarmUseCase(repository),
            deleteAlarm = DeleteAlarmUseCase(repository),
            toggleAlarm = ToggleAlarmUseCase(repository)
        )
    }
}