package com.example.pixabay

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("api/")

    fun getImage(
        @Query("q") search : String,
        @Query("page") page : Int,
        @Query("per_page") perPage : Int = 3,
        @Query("key") key: String = "35759694-595717ab859c4f51f28810c5f"

    ) : Call<PixabayModel>
}

