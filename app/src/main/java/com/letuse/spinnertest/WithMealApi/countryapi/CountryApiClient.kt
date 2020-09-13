package com.ppak.firstsmallprojectapplication.api.api.countryapi

import com.ppak.firstsmallprojectapplication.model.model.countrymodel.CountryModel
import com.ppak.firstsmallprojectapplication.model.model.countrymodel.Meal
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryApiClient {
    private val countryInterface:CountryInterface

         val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

       countryInterface = retrofit.create(CountryInterface::class.java)
    }

    fun getCountryApi(): Call<CountryModel> {
        return countryInterface.getCountry("list")
    }
}