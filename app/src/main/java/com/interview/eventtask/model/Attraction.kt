package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Attraction(
    @SerializedName("classifications")
    val classifications: List<ClassificationX>,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("test")
    val test: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("upcomingEvents")
    val upcomingEvents: UpcomingEvents,
    @SerializedName("url")
    val url: String
)