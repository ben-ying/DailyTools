package com.yjh.dt.dailytools.di.module

import android.app.Application
import androidx.room.Room
import com.yjh.dt.dailytools.MyApplication
import com.yjh.dt.dailytools.db.CurrencyDao
import com.yjh.dt.dailytools.db.MyDatabase
import com.yjh.dt.dailytools.repository.ExchangeRepository
import com.yjh.dt.dailytools.retrofit.Webservice
import com.yjh.dt.dailytools.viewmodel.ExchangeViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton




@Module
class ExchangeModule constructor(val myApplication: Application) {

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
    fun provideExchangeRepository(webservice: Webservice, dao: CurrencyDao): ExchangeRepository {
        return ExchangeRepository(webservice, dao)
    }

    @Provides
    fun provideExchangeViewModel(repository: ExchangeRepository): ExchangeViewModel {
        return ExchangeViewModel(repository)
    }
}