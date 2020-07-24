package com.yjh.dt.dailytools.retrofit

import com.yjh.dt.dailytools.model.HttpResponse
import retrofit2.Response

class ApiResponse<T> {
    val code: Int
    val body: T?
    val errorMessage: String?

    constructor(error: Throwable) {
        code = 500
        body = null
        errorMessage = error.message
    }

    constructor(response: Response<T>) {
//        Timber.d("http request: %s", response.raw().request())
//        Timber.d("http response: %s", Gson().toJson(response.body()))
        val responseBody: HttpResponse<*>? = response.body() as HttpResponse<*>?

        code = responseBody!!.code
        if (responseBody.isSuccessful) {
            body = response.body()
            errorMessage = null
        } else {
            errorMessage = responseBody.message
            body = null
        }
    }

    val isSuccessful: Boolean
        get() = code == 200

    val isEmpty: Boolean
        get() = body == null
}
