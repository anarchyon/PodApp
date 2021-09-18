package project.paveltoy.podapp.data.entities

import android.net.Uri

data class Note(
    val id: String,
    val title: String,
    val text: String,
    var image: String? = null,
)
