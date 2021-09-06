package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.data.entities.EpicImage

interface DataLoader {
    fun loadPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit)

    fun loadAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit)

    fun loadAllEpicEnhanced(callback: (epicDays: List<EpicDay>) -> Unit)

    fun loadNaturalByDate(date: String, callback: (epicImages: List<EpicImage>) -> Unit)

    fun loadEnhancedByDate(date: String, callback: (epicImages: List<EpicImage>) -> Unit)
}