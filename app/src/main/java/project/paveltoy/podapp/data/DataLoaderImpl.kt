package project.paveltoy.podapp.data

import project.paveltoy.podapp.BuildConfig
import project.paveltoy.podapp.data.entities.Apod
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_KEY_VALUE = BuildConfig.NasaApiKey

class DataLoaderImpl: DataLoader {
    private val nasaServerApi = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NasaServerApi::class.java)

    override fun loadPictureOfTheDay(date: String, callback: Callback<Apod>) {
        nasaServerApi.getApod(API_KEY_VALUE, date).enqueue(callback)
    }

}