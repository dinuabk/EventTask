package com.interview.eventtask.model


import com.google.gson.annotations.SerializedName

data class ClassificationX(
    @SerializedName("family")
    val family: Boolean,
    @SerializedName("genre")
    val genre: GenreX,
    @SerializedName("primary")
    val primary: Boolean,
    @SerializedName("segment")
    val segment: SegmentX,
    @SerializedName("subGenre")
    val subGenre: SubGenreX,
    @SerializedName("subType")
    val subType: SubType,
    @SerializedName("type")
    val type: Type
)