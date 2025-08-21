package com.example.android_library

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("buku")
    fun getBuku(): Call<List<Buku>>
}
