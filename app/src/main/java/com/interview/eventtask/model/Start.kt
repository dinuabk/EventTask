package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Start(
    @SerializedName("dateTBA")
    val dateTBA: Boolean,
    @SerializedName("dateTBD")
    val dateTBD: Boolean,
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("localDate")
    val localDate: String,
    @SerializedName("localTime")
    val localTime: String,
    @SerializedName("noSpecificTime")
    val noSpecificTime: Boolean,
    @SerializedName("timeTBA")
    val timeTBA: Boolean
)