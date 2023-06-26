package com.example.intelikartassignment.network

import retrofit2.http.GET

interface ApiService {
    @GET("4509d8cc-2fe4-439c-9075-b9196c6ac455")
    suspend fun getCategories(): List<Category>
}