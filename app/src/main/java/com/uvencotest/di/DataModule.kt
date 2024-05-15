package com.uvencotest.di

import android.content.Context
import com.uvencotest.data.DetailsRepositoryImpl
import com.uvencotest.data.api.LocalClient
import com.uvencotest.data.impl.SharedPrefsLocalClient
import com.uvencotest.domain.api.DetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideDetailsRepository(localClient: LocalClient): DetailsRepository {
        return DetailsRepositoryImpl(localClient)
    }

    @Provides
    @Singleton
    fun provideLocalClient(@ApplicationContext context: Context): LocalClient {
        return SharedPrefsLocalClient(context)
    }
}