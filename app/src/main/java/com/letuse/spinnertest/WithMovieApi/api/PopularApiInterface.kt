package com.letuse.finddoctor.api.TestMovieAPI.popular

import com.letuse.finddoctor.model.TestMovie.popular.PopularModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularApiInterface {
    @GET("popular")
    fun getPopularInterface(
        @Query("api_key") apiKey : String
    ) : Call<PopularModel>
}