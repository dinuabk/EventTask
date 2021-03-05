package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class EmbeddedX(
    @SerializedName("attractions")
    val attractions: List<Attraction>,
    @SerializedName("venues")
    val venues: List<Venue>
)