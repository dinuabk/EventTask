package com.interview.eventtask.`interface`

import com.interview.eventtask.model.Embedded
import com.interview.eventtask.model.Event
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/events.json?apikey=PeGhsWyOKSpmgAqy5rPw1aC3UFtcjNhE")
    fun getEventTask() : Call<Embedded>

    companion object {

        var BASE_URL = "https://app.ticketmaster.com/discovery/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}