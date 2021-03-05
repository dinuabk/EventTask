package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: Self
)