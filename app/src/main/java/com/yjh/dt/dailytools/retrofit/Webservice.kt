package com.yjh.dt.dailytools.retrofit

import com.yjh.dt.dailytools.model.Currency
import com.yjh.dt.dailytools.model.HttpResponse
import com.yjh.dt.dailytools.model.HttpResponseResult
import retrofit2.Call
import retrofit2.http.GET

interface Webservice {
    @GET("currencies/")
    fun getCurrencyList(): Call<HttpResponse<HttpResponseResult<List<Currency>>>>
}