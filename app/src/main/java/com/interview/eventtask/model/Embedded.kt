package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Embedded(
    @SerializedName("events")
    val events: List<Event>
)