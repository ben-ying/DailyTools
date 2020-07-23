package com.yjh.dt.dailytools.retrofit

import com.yjh.dt.dailytools.room.Currency
import retrofit2.Call
import retrofit2.http.GET

interface Webservice {
    @GET("currencies/")
    fun getCurrencyList(): Call<List<Currency>>
}