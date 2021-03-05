package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)