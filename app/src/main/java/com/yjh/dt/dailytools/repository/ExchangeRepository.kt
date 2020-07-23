package com.yjh.dt.dailytools.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.yjh.dt.dailytools.db.CurrencyDao
import com.yjh.dt.dailytools.model.Currency
import com.yjh.dt.dailytools.model.HttpResponse
import com.yjh.dt.dailytools.model.HttpResponseResult
import com.yjh.dt.dailytools.retrofit.ApiResponse
import com.yjh.dt.dailytools.retrofit.NetworkBoundResource
import com.yjh.dt.dailytools.retrofit.Webservice
import com.yjh.dt.dailytools.util.RateLimiter
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRepository @Inject constructor(
    private val mWebservice: Webservice,
    private val mDao: CurrencyDao
//    private val mRepoListRateLimit: RateLimiter<String?>? = RateLimiter(30, TimeUnit.MINUTES)
){
//    fun getCurrencyList(): LiveData<List<Currency>> {
//        val data = MutableLiveData<List<Currency>>()
//        mWebservice.getCurrencyList().enqueue(
//            object : Callback<HttpResponse<HttpResponseResult<List<Currency>>>> {
//            override fun onResponse(call: Call<HttpResponse<HttpResponseResult<List<Currency>>>>,
//                                    response: Response<HttpResponse<HttpResponseResult<List<Currency>>>>) {
//                data.value = response.body()?.result?.results
//            }
//            override fun onFailure(call: Call<HttpResponse<HttpResponseResult<List<Currency>>>>,
//                                   t: Throwable) {
//                Log.d("test1234", call.request().url().toString() + ": " + t.message)
//            }
//        })
//        return data
//    }

    fun getCurrencyList(): LiveData<List<Currency>> {
        return object : NetworkBoundResource<List<Currency>, HttpResponse<HttpResponseResult<List<Currency>>>>() {
            override fun saveCallResult(item: HttpResponse<HttpResponseResult<List<Currency>>>) {
                mDao.saveAll(item.result.results)
            }

            override fun shouldFetch(data: List<Currency>?): Boolean {
                val shouldFetch = data == null
                return shouldFetch
            }

            override fun loadFromDb(): LiveData<List<Currency>> {
                return mDao.loadAll()
            }

            override fun createCall():
                    LiveData<ApiResponse<HttpResponse<HttpResponseResult<List<Currency>>>>> {
                return mWebservice.getCurrencyList()
            }

            override fun onFetchFailed() {
                super.onFetchFailed()
            }
        }.asLiveData()
    }
}