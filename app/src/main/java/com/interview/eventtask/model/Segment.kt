package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Segment(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)