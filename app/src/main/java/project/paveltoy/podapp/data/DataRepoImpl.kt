package project.paveltoy.podapp.data

import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.data.entities.EpicImage

class DataRepoImpl(
    private val loader: DataLoader = DataLoaderImpl()
) : DataRepo {

    override fun getPictureOfTheDay(date: String, callback: (apod: Apod) -> Unit) {
        loader.loadPictureOfTheDay(date, callback)
    }

    override fun getAllEpicNatural(callback: (epicDays: List<EpicDay>) -> Unit) {
        loader.loadAllEpicNatural(callback)
    }

    override fun getAllEpicNaturalByDate(date: String, callback: (epicImages: List<String>) -> Unit) {
        loader.loadNaturalByDate(date) {
            callback(prepareNaturalImageUrls(it, date))
        }
    }

    private fun prepareNaturalImageUrls(epicImages: List<EpicImage>, date: String): List<String> {
        return prepareImageUrls(NATURAL_IMAGE_BASE_URL, epicImages, date)
    }

    private fun prepareEnhancedImageUrls(epicImages: List<EpicImage>, date: String): List<String> {
        return prepareImageUrls(ENHANCED_IMAGE_BASE_URL, epicImages, date)
    }

    private fun prepareImageUrls(imageBaseUrl: String, epicImages: List<EpicImage>, date: String): List<String> {
        val listImageUrls: ArrayList<String> = arrayListOf()
        epicImages.forEach {
            val dateInUrls = date.replace("-", "/")
            val url = "$imageBaseUrl$dateInUrls/$IMAGE_TYPE/${it.image}.$IMAGE_TYPE?api_key=$API_KEY_VALUE"
            listImageUrls.add(url)
        }
        return listImageUrls
    }

    override fun getEpicNatural(date: String, imageType: String, fileName: String) {
    }

    override fun getAllEpicEnhanced(callback: (epicDays: List<EpicDay>) -> Unit) {
        loader.loadAllEpicEnhanced(callback)
    }

    override fun getAllEpicEnhancedByDate(date: String, callback: (epicImages: List<String>) -> Unit) {
        loader.loadEnhancedByDate(date) {
            callback(prepareEnhancedImageUrls(it, date))
        }
    }

    override fun getEpicEnhanced(date: String, imageType: String, fileName: String) {
    }
}