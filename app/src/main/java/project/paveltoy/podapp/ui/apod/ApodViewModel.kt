package project.paveltoy.podapp.ui.apod

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.DataRepo
import project.paveltoy.podapp.data.DataRepoImpl
import project.paveltoy.podapp.data.entities.Apod
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "yyyy-MM-dd"

class ApodViewModel(
    private val repo: DataRepo = DataRepoImpl(),
) : ViewModel() {
    val apodLiveData = MutableLiveData<Apod>()

    fun loadApod(dayOffset: Int) {
        val date = getDateAsString(dayOffset)
        repo.getPictureOfTheDay(date, this::setApodLiveData)
    }

    fun loadApod(date: String) {
        repo.getPictureOfTheDay(date, this::setApodLiveData)
    }

    private fun setApodLiveData(apod: Apod) {
        apodLiveData.value = apod
    }

    private fun getDateAsString(dayOffset: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, dayOffset)
        val date = calendar.time
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)
    }
}