package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class ImageX(
    @SerializedName("fallback")
    val fallback: Boolean,
    @SerializedName("height")
    val height: Int,
    @SerializedName("ratio")
    val ratio: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)