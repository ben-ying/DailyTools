package com.yjh.dt.dailytools.retrofit

import com.google.gson.Gson
import com.yjh.dt.dailytools.model.Currency
import com.yjh.dt.dailytools.model.HttpResponse
import com.yjh.dt.dailytools.model.HttpResponseResult
import retrofit2.Response

class ApiResponse<T> {
    private val mCode: Int
    private val mBody: T?
    private val mErrorMessage: String?

    constructor(error: Throwable) {
        mCode = 500
        mBody = null
        mErrorMessage = error.message
    }

    constructor(response: Response<T>) {
//        Timber.d("http request: %s", response.raw().request())
//        Timber.d("http response: %s", Gson().toJson(response.body()))
        val responseBody: HttpResponse<*>? = response.body() as HttpResponse<*>?

        mCode = responseBody!!.code
        if (responseBody.isSuccessful) {
            mBody = response.body()
            mErrorMessage = null
        } else {
            mErrorMessage = responseBody.message
            mBody = null
        }
    }

    val isSuccessful: Boolean
        get() = mCode == 200
}
