package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod

interface DataLoader {
    fun loadPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit)
}