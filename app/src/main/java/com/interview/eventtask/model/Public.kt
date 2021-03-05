package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Public(
    @SerializedName("startTBA")
    val startTBA: Boolean,
    @SerializedName("startTBD")
    val startTBD: Boolean
)