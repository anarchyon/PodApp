package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import retrofit2.Callback

interface DataLoader {
    fun loadPictureOfTheDay(date: String, callback: Callback<Apod>)
}