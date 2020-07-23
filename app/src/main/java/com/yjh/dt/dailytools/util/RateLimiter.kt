package com.yjh.dt.dailytools.util

import android.os.SystemClock
import androidx.collection.ArrayMap
import java.util.concurrent.TimeUnit

class RateLimiter<KEY> constructor(timeout: Int, timeUnit: TimeUnit) {
    private val mTimestamps: ArrayMap<KEY, Long> = ArrayMap()
    private var mTimeout: Long = 0

    init {
        mTimeout = timeUnit.toMillis(timeout.toLong())
    }

    @Synchronized
    fun shouldFetch(key: KEY): Boolean {
        val lastFetched = mTimestamps[key]
        val now = now()
        if (lastFetched == null) {
            mTimestamps[key] = now
            return true
        }
        if (now - lastFetched > mTimeout) {
            mTimestamps[key] = now
            return true
        }
        return false
    }

    private fun now(): Long {
        return SystemClock.uptimeMillis()
    }

    @Synchronized
    fun reset(key: KEY?) {
        mTimestamps.remove(key)
    }
}