package project.paveltoy.podapp.data.entities

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NasaDataChecker {
    var apodCallback: ((apod: Apod) -> Unit)? = null
    var epicDaysCallback: ((epicDays: List<EpicDay>) -> Unit)? = null

    val apodLoadCallback = object : Callback<Apod> {
        override fun onResponse(call: Call<Apod>, response: Response<Apod>) {
            val apod = response.body()
            if (response.isSuccessful && apod != null) {
                if (isValidApod(apod)) apodCallback?.let { it(apod) }
            }
        }

        override fun onFailure(call: Call<Apod>, t: Throwable) {

        }
    }

    private fun isValidApod(apod: Apod): Boolean {
        //todo
        return true
    }

    val epicDaysLoadCallback = object : Callback<List<EpicDay>> {
        override fun onResponse(call: Call<List<EpicDay>>, response: Response<List<EpicDay>>) {
            val epicDays = response.body()
            if (response.isSuccessful && epicDays != null) {
                if (isValidEpicDays(epicDays)) epicDaysCallback?.let { it(epicDays) }
            }
        }

        override fun onFailure(call: Call<List<EpicDay>>, t: Throwable) {
            Log.d("@@@", t.message?:"error")
        }

    }

    private fun isValidEpicDays(epicDays: List<EpicDay>): Boolean {
        // TODO: 05.09.2021
        return true
    }
}