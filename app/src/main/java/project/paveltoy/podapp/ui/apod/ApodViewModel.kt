package project.paveltoy.podapp.ui.apod

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.DataRepo
import project.paveltoy.podapp.data.DataRepoImpl
import project.paveltoy.podapp.data.entities.Apod
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApodViewModel(
    private val repo: DataRepo = DataRepoImpl(),
): ViewModel() {
    val apodLiveData = MutableLiveData<Apod>()

    private val callback = object : Callback<Apod> {
        override fun onResponse(call: Call<Apod>, response: Response<Apod>) {
            val apod = response.body()
            if (response.isSuccessful && apod != null) {
                apodLiveData.value = apod
            }
        }

        override fun onFailure(call: Call<Apod>, t: Throwable) {

        }

    }

    fun getApod(date: String) {
        repo.getPictureOfTheDay(date, callback)
    }
}