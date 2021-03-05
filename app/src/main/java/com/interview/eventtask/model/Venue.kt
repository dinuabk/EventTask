package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("address")
    val address: Address,
    @SerializedName("city")
    val city: City,
    @SerializedName("country")
    val country: Country,
    @SerializedName("id")
    val id: String,
    @SerializedName("_links")
    val links: LinksX,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("postalCode")
    val postalCode: String,
    @SerializedName("state")
    val state: State,
    @SerializedName("test")
    val test: Boolean,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("upcomingEvents")
    val upcomingEvents: UpcomingEventsX
)