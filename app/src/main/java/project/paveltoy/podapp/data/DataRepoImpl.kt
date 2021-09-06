package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay

class DataRepoImpl(
    private val loader: DataLoader = DataLoaderImpl()
) : DataRepo {

    override fun getPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit) {
        loader.loadPictureOfTheDay(date, callback)
    }

    override fun getAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit) {
        loader.loadAllEpicNatural(callback)
    }

    override fun getAllEpicNaturalByDate(date: String) {
    }

    override fun getEpicNatural(date: String, imageType: String, fileName: String) {
    }

    override fun getAllEpicEnhanced(callback: (epicDays: List<EpicDay>) -> Unit) {
        loader.loadAllEpicEnhanced(callback)
    }

    override fun getAllEpicEnhancedByDate(date: String) {
    }

    override fun getEpicEnhanced(date: String, imageType: String, fileName: String) {
    }
}