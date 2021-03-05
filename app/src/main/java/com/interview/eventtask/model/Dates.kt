package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("spanMultipleDays")
    val spanMultipleDays: Boolean,
    @SerializedName("start")
    val start: Start,
    @SerializedName("status")
    val status: Status
)