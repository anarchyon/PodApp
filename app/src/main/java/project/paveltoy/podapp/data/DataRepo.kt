package project.paveltoy.podapp.data

interface DataRepo {
    fun getPictureOfTheDay(date: String?)

    fun getAllEpicNatural()

    fun getAllEpicNaturalByDate(date: String)

    fun getEpicNatural(date: String, imageType: String, fileName: String)

    fun getAllEpicEnhanced()

    fun getAllEpicEnhancedByDate(date: String)

    fun getEpicEnhanced(date: String, imageType: String, fileName: String)
}