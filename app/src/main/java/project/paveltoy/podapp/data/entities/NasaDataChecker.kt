package project.paveltoy.podapp.data.entities

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NasaDataChecker {
    lateinit var apodCallback: (apod: Apod) -> Unit

    val apodLoadCallback = object : Callback<Apod> {
        override fun onResponse(call: Call<Apod>, response: Response<Apod>) {
            val apod = response.body()
            if (response.isSuccessful && apod != null) {
                if (isValidApod(apod)) apodCallback(apod)
            }
        }

        override fun onFailure(call: Call<Apod>, t: Throwable) {

        }
    }

    private fun isValidApod(apod: Apod): Boolean {
        //todo
        return true
    }
}