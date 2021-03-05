package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class SegmentX(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)