package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Seatmap(
    @SerializedName("staticUrl")
    val staticUrl: String
)