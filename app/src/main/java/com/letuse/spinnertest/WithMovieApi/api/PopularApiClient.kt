package com.letuse.finddoctor.api.TestMovieAPI.popular

import com.letuse.finddoctor.model.TestMovie.popular.PopularModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PopularApiClient {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"

    companion object{
        val API_KEY = "cfdad7456adae302794611f3dcb19946"
    }

    private val popularApiInterface : PopularApiInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        popularApiInterface = retrofit.create(PopularApiInterface::class.java)
    }

    fun getPopularClient(apiKey : String) : Call<PopularModel>{
        return popularApiInterface.getPopularInterface(apiKey)
    }

}