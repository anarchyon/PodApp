package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import retrofit2.Callback

class DataRepoImpl(
    private val loader: DataLoader = DataLoaderImpl()
) : DataRepo {

    override fun getPictureOfTheDay(date: String, callback: Callback<Apod>) {
        loader.loadPictureOfTheDay(date, callback)
    }

    override fun getAllEpicNatural() {
    }

    override fun getAllEpicNaturalByDate(date: String) {
    }

    override fun getEpicNatural(date: String, imageType: String, fileName: String) {
    }

    override fun getAllEpicEnhanced() {
    }

    override fun getAllEpicEnhancedByDate(date: String) {
    }

    override fun getEpicEnhanced(date: String, imageType: String, fileName: String) {
    }
}