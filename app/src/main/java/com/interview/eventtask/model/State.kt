package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("name")
    val name: String,
    @SerializedName("stateCode")
    val stateCode: String
)