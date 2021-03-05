package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("countryCode")
    val countryCode: String,
    @SerializedName("name")
    val name: String
)