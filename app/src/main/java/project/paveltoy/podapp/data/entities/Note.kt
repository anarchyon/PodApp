package project.paveltoy.podapp.data.entities

import java.util.*

data class Note(
    val title: String,
    val text: String,
    var image: String? = null,
    val id: String = UUID.randomUUID().toString(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
