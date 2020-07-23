package com.yjh.dt.dailytools.di.module

import com.yjh.dt.dailytools.repository.ExchangeRepository
import com.yjh.dt.dailytools.viewmodel.ExchangeViewModel
import dagger.Module
import dagger.Provides

@Module
class ExchangeModule {
    @Provides
    fun provideExchangeRepository(): ExchangeRepository {
        return ExchangeRepository()
    }

    @Provides
    fun provideExchangeViewModel(repository: ExchangeRepository): ExchangeViewModel {
        return ExchangeViewModel(repository)
    }
}