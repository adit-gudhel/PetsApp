package com.aditgudhel.petsapp.api

import com.aditgudhel.petsapp.BuildConfig
import com.aditgudhel.petsapp.api.response.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.API_KEY
    }

    @Headers("Accept-version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): PhotoResponse

}