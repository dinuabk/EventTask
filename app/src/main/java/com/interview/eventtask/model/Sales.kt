package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Sales(
    @SerializedName("public")
    val `public`: Public
)