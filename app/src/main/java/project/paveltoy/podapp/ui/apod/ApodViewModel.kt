package project.paveltoy.podapp.ui.apod

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.DataRepo
import project.paveltoy.podapp.data.DataRepoImpl
import project.paveltoy.podapp.data.entities.Apod

class ApodViewModel(
    private val repo: DataRepo = DataRepoImpl(),
): ViewModel() {
    val apodLiveData = MutableLiveData<Apod>()

    fun loadApod(date: String) {
        repo.getPictureOfTheDay(date, this::setApodLiveData)
    }

    private fun setApodLiveData(apod: Apod) {
        apodLiveData.value = apod
    }
}