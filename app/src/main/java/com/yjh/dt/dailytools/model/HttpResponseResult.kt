package com.yjh.dt.dailytools.model

import com.google.gson.annotations.SerializedName
import java.util.*

class HttpResponseResult<T> constructor(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("results")
    val results: T
) {
}