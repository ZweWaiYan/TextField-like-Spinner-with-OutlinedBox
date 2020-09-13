package com.letuse.spinnertest.WithMovieApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.letuse.finddoctor.api.TestMovieAPI.popular.PopularApiClient
import com.letuse.finddoctor.model.TestMovie.popular.PopularModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularViewModel : ViewModel(){
    private var popular : MutableLiveData<PopularModel> = MutableLiveData()

    fun getPopular() : LiveData<PopularModel> = popular

    fun loadPopular() {
        val apiclient = PopularApiClient()

        val callapi = apiclient.getPopularClient(PopularApiClient.API_KEY)

        callapi.enqueue(object : Callback<PopularModel>{
            override fun onFailure(call: Call<PopularModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<PopularModel>, response: Response<PopularModel>) {
                response?.isSuccessful.let {
                    val popularResult = PopularModel(response.body()?.results?: emptyList())
                    popular.value = popularResult
                }
            }

        })
    }
}