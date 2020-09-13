package com.ppak.firstsmallprojectapplication.api.api.countryapi

import com.ppak.firstsmallprojectapplication.model.model.countrymodel.CountryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryInterface {
    @GET("list.php")
    fun getCountry(
        @Query("a") country:String
    ): Call<CountryModel>
}