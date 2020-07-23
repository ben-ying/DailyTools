package com.yjh.dt.dailytools.model

import com.google.gson.annotations.SerializedName
import java.util.*

class HttpResponse<T> constructor(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: T
) {

}