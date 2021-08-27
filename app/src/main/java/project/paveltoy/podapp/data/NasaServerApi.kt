package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NasaServerApi {
    @GET("planetary/apod")
    fun getApod(
        @Query("api_key") apiKey: String,
        @Query("date") date: String
    ): Call<Apod>
}