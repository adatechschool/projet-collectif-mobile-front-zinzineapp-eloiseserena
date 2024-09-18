package com.example.zinzineapp
import retrofit2.Call
import retrofit2.http.GET
interface ApiService {

    @GET("emissions")
    fun getEmissions(): Call<List<Emission>>
}