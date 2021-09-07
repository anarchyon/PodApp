package project.paveltoy.podapp.data

import project.paveltoy.podapp.BuildConfig
import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.data.entities.EpicImage
import project.paveltoy.podapp.data.entities.NasaDataChecker
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY_VALUE = BuildConfig.NasaApiKey
private const val BASE_URL = "https://api.nasa.gov/"
const val NATURAL_IMAGE_BASE_URL = "https://api.nasa.gov/EPIC/archive/natural/"
const val ENHANCED_IMAGE_BASE_URL = "https://api.nasa.gov/EPIC/archive/enhanced/"
const val IMAGE_TYPE = "jpg"

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

    override fun loadAllEpicEnhanced(callback: (epicDays: List<EpicDay>) -> Unit) {
        NasaDataChecker.epicDaysCallback = callback
        nasaServerApi.getAllEnhanced(API_KEY_VALUE).enqueue(NasaDataChecker.epicDaysLoadCallback)
    }

    override fun loadNaturalByDate(date: String, callback: (epicImages: List<EpicImage>) -> Unit) {
        NasaDataChecker.epicImagesCallback = callback
        nasaServerApi.getNaturalByDate(date, API_KEY_VALUE).enqueue(NasaDataChecker.epicImagesLoadCallback)
    }

    override fun loadEnhancedByDate(date: String, callback: (epicImages: List<EpicImage>) -> Unit) {
        NasaDataChecker.epicImagesCallback = callback
        nasaServerApi.getEnhancedByDate(date, API_KEY_VALUE).enqueue(NasaDataChecker.epicImagesLoadCallback)
    }


}