package project.paveltoy.podapp.data

import project.paveltoy.podapp.BuildConfig
import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.data.entities.NasaDataChecker
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_KEY_VALUE = BuildConfig.NasaApiKey
private const val BASE_URL = "https://api.nasa.gov/"

class DataLoaderImpl : DataLoader {
    private val nasaServerApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NasaServerApi::class.java)

    override fun loadPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit) {
        NasaDataChecker.apodCallback = callback
        nasaServerApi.getApod(API_KEY_VALUE, date).enqueue(NasaDataChecker.apodLoadCallback)
    }

    override fun loadAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit) {
        NasaDataChecker.epicDaysCallback = callback
        nasaServerApi.getAllNatural(API_KEY_VALUE).enqueue(NasaDataChecker.epicDaysLoadCallback)
    }
}