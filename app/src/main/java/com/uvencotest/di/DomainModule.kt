package com.uvencotest.di

import com.uvencotest.domain.api.DetailsInteractor
import com.uvencotest.domain.api.DetailsRepository
import com.uvencotest.domain.impl.DetailsInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideDetailsInteractor(detailsRepository: DetailsRepository): DetailsInteractor {
        return DetailsInteractorImpl(detailsRepository)
    }
}