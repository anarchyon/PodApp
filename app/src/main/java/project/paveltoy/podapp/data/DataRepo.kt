package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.data.entities.EpicImage

interface DataRepo {
    fun getPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit)

    fun getAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit)

    fun getAllEpicNaturalByDate(date: String, callback: (epicImages: List<String>) -> Unit)

    fun getEpicNatural(date: String, imageType: String, fileName: String)

    fun getAllEpicEnhanced(callback: (epicDays: List<EpicDay>) -> Unit)

    fun getAllEpicEnhancedByDate(date: String, callback: (epicImages: List<String>) -> Unit)

    fun getEpicEnhanced(date: String, imageType: String, fileName: String)
}