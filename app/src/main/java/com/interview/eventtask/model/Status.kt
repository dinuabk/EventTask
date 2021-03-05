package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("code")
    val code: String
)