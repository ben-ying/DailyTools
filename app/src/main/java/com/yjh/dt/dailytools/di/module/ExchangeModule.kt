package com.yjh.dt.dailytools.di.module

import android.app.Application
import androidx.room.Room
import com.android.example.github.util.LiveDataCallAdapter
import com.android.example.github.util.LiveDataCallAdapterFactory
import com.yjh.dt.dailytools.db.CurrencyDao
import com.yjh.dt.dailytools.db.MyDatabase
import com.yjh.dt.dailytools.repository.ExchangeRepository
import com.yjh.dt.dailytools.retrofit.AppExecutors
import com.yjh.dt.dailytools.retrofit.Webservice
import com.yjh.dt.dailytools.viewmodel.ExchangeViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ExchangeModule constructor(val myApplication: Application) {

    @Provides
    fun provideWebservice(): Webservice {
        return Retrofit.Builder()
            .baseUrl("http://mybackend.online:8000/tools/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(Webservice::class.java)
    }

    @Provides
    fun provideApplication(): Application {
        return myApplication
    }

    @Provides
    fun provideMyDatabase(application: Application): MyDatabase {
        return Room.databaseBuilder(application, MyDatabase::class.java, "tools.db").build()
    }

    @Provides
    fun provideCurrencyDao(myDatabase: MyDatabase): CurrencyDao {
        return myDatabase.currencyDao()
    }

    @Provides
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors()
    }

    @Provides
    fun provideExchangeRepository(webservice: Webservice, dao: CurrencyDao,
                                  appExecutors: AppExecutors): ExchangeRepository {
        return ExchangeRepository(webservice, dao, appExecutors)
    }

    @Provides
    fun provideExchangeViewModel(repository: ExchangeRepository): ExchangeViewModel {
        return ExchangeViewModel(repository)
    }
}