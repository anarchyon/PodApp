package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "api_key"
private const val APOD = "planetary/apod"
private const val EPIC_NATURAL_ALL = "EPIC/api/natural/all"
private const val EPIC_ENHANCED_ALL = "EPIC/api/enhanced/all"
private const val DATE = "date"

interface NasaServerApi {
    @GET(APOD)
    fun getApod(
        @Query(API_KEY) apiKey: String,
        @Query(DATE) date: String
    ): Call<Apod>

    @GET(EPIC_NATURAL_ALL)
    fun getAllNatural(
        @Query(API_KEY) apiKey: String,
    ): Call<List<EpicDay>>

    @GET(EPIC_ENHANCED_ALL)
    fun getAllEnhanced(
        @Query(API_KEY) apiKey: String,
    ): Call<List<EpicDay>>
}