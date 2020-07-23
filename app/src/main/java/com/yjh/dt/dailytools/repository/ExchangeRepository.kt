package com.yjh.dt.dailytools.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yjh.dt.dailytools.retrofit.Webservice
import com.yjh.dt.dailytools.room.Currency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExchangeRepository @Inject constructor(
//    private val mWebservice: Webservice,
//    private var mCurrencyListLiveData: LiveData<List<Currency>>?
){
    fun getCurrencyList(): LiveData<List<Currency>> {
//        if (mCurrencyListLiveData != null) {
//            return mCurrencyListLiveData as LiveData<List<Currency>>
//        }
        val data = MutableLiveData<List<Currency>>()
//        mCurrencyListLiveData = data
//        mWebservice.getCurrencyList().enqueue(object : Callback<List<Currency>> {
//            override fun onResponse(call: Call<List<Currency>>, response: Response<List<Currency>>) {
//                data.value = response.body()
//                Log.d("test1234", data.value.toString())
//            }
//            override fun onFailure(call: Call<List<Currency>>, t: Throwable) {
//                TODO()
//            }
//        })
        return data
    }
}