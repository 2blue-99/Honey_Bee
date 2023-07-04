package com.example.data.module

import android.content.Context
import com.example.data.manager.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 2023-06-28
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object AppDataModule {
    @Singleton
    @Provides
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager {
        return PreferenceManager(context)
    }
}