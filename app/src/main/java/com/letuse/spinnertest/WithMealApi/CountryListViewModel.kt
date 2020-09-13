package com.letuse.spinnertest.WithMealApi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ppak.firstsmallprojectapplication.api.api.countryapi.CountryApiClient
import com.ppak.firstsmallprojectapplication.model.model.countrymodel.CountryModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListViewModel:ViewModel() {
    private var country : MutableLiveData<CountryModel> = MutableLiveData()

    fun getCountry() : LiveData<CountryModel> =country

    fun loadCountry(){
        val countryApiClient:CountryApiClient = CountryApiClient()

        val call = countryApiClient.getCountryApi()

        call.enqueue(object : Callback<CountryModel>{
            override fun onFailure(call: Call<CountryModel>, t: Throwable) {
                Log.d("Result Error>>>>>>",t.toString())
            }

            override fun onResponse(call: Call<CountryModel>, response: Response<CountryModel>) {
                response?.isSuccessful.let {
                    val countryResult= CountryModel(response.body()?.meals?: emptyList())
                    Log.d("Res>>>>>",response.toString())
                    country.value=countryResult //response.body()
                }
            }

        })
    }
}