package project.paveltoy.podapp.data.entities

import com.google.gson.annotations.SerializedName

data class Apod(
    val date: String,
    val explanation: String,
    @SerializedName("hdurl") val hdUrl: String,
    @SerializedName("media_type") val mediaType: String,
    val title: String,
    val url: String,
)
