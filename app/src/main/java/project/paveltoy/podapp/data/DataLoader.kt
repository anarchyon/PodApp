package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay

interface DataLoader {
    fun loadPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit)

    fun loadAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit)
}