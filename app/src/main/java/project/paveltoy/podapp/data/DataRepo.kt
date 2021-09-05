package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay

interface DataRepo {
    fun getPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit)

    fun getAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit)

    fun getAllEpicNaturalByDate(date: String)

    fun getEpicNatural(date: String, imageType: String, fileName: String)

    fun getAllEpicEnhanced()

    fun getAllEpicEnhancedByDate(date: String)

    fun getEpicEnhanced(date: String, imageType: String, fileName: String)
}