package com.yjh.dt.dailytools.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yjh.dt.dailytools.retrofit.Webservice
import com.yjh.dt.dailytools.model.Currency
import com.yjh.dt.dailytools.model.HttpResponse
import com.yjh.dt.dailytools.model.HttpResponseResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRepository @Inject constructor(
    private val mWebservice: Webservice
){
    fun getCurrencyList(): LiveData<List<Currency>> {
        val data = MutableLiveData<List<Currency>>()
        mWebservice.getCurrencyList().enqueue(
            object : Callback<HttpResponse<HttpResponseResult<List<Currency>>>> {
            override fun onResponse(call: Call<HttpResponse<HttpResponseResult<List<Currency>>>>,
                                    response: Response<HttpResponse<HttpResponseResult<List<Currency>>>>) {
                data.value = response.body()?.result?.results
            }
            override fun onFailure(call: Call<HttpResponse<HttpResponseResult<List<Currency>>>>,
                                   t: Throwable) {
                Log.d("test1234", call.request().url().toString() + ": " + t.message)
            }
        })
        return data
    }
}