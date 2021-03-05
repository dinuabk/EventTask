package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class UpcomingEvents(
    @SerializedName("ticketmaster")
    val ticketmaster: Int,
    @SerializedName("tmr")
    val tmr: Int,
    @SerializedName("_total")
    val total: Int
)