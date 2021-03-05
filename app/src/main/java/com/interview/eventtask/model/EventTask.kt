package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class EventTask(
    @SerializedName("_embedded")
    val embedded: Embedded
)