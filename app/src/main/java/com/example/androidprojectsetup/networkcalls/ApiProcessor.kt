package com.example.androidprojectsetup.networkcalls


interface ApiProcessor<T> {
    suspend fun sendRequest(retrofitApi: RetrofitApi): T
    fun onResponse(res: T)
    fun onError(message: String) {}
}