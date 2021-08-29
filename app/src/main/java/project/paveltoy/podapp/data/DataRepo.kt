package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod

interface DataRepo {
    fun getPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit)

    fun getAllEpicNatural()

    fun getAllEpicNaturalByDate(date: String)

    fun getEpicNatural(date: String, imageType: String, fileName: String)

    fun getAllEpicEnhanced()

    fun getAllEpicEnhancedByDate(date: String)

    fun getEpicEnhanced(date: String, imageType: String, fileName: String)
}