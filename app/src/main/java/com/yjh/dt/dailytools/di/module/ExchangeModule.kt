package com.yjh.dt.dailytools.di.module

import com.yjh.dt.dailytools.repository.ExchangeRepository
import com.yjh.dt.dailytools.retrofit.Webservice
import com.yjh.dt.dailytools.viewmodel.ExchangeViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ExchangeModule {

    @Provides
    fun provideWebservice(): Webservice {
        return Retrofit.Builder()
            .baseUrl("http://mybackend.online:8000/tools/api/")
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(Webservice::class.java)
    }

    @Provides
    fun provideExchangeRepository(webservice: Webservice): ExchangeRepository {
        return ExchangeRepository(webservice)
    }

    @Provides
    fun provideExchangeViewModel(repository: ExchangeRepository): ExchangeViewModel {
        return ExchangeViewModel(repository)
    }
}