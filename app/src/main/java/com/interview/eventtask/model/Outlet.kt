package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Outlet(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)