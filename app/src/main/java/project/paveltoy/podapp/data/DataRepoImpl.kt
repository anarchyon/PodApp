package project.paveltoy.podapp.data

class DataRepoImpl: DataRepo {
    private val loader: DataLoader? = null

    constructor(
        loader: DataRepoImpl = DataRepoImpl()
    )

    override fun getPictureOfTheDay(date: String?) {
        loader?.loadPictureOfTheDay(date)
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