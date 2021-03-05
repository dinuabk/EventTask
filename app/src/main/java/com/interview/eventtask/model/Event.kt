package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName
import java.lang.reflect.Constructor


data class Event(
    @SerializedName("classifications")
    val classifications: List<Classification>,
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("_embedded")
    val embedded: EmbeddedX,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<ImageX>,
    @SerializedName("_links")
    val links: LinksXX,
    @SerializedName("locale")
    val locale: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("outlets")
    val outlets: List<Outlet>,
    @SerializedName("sales")
    val sales: Sales,
    @SerializedName("seatmap")
    val seatmap: Seatmap,
    @SerializedName("test")
    val test: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String)
// {
//    constructor() : this()
//}

