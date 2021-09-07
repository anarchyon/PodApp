package project.paveltoy.podapp.ui.epic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.DataRepo
import project.paveltoy.podapp.data.DataRepoImpl
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.data.entities.EpicImage
import java.net.URI

class EpicViewModel(
    private val repo: DataRepo = DataRepoImpl()
) : ViewModel() {
    private var _naturalColorsLiveData = MutableLiveData<List<EpicDay>>()
    val naturalColorsLiveData get() = _naturalColorsLiveData
    private var _enhancedColorsLiveData = MutableLiveData<List<EpicDay>>()
    val enhancedColorsLiveData get() = _enhancedColorsLiveData
    private var _epicImageLiveData = MutableLiveData<List<String>>()
    val epicImageLiveData get() = _epicImageLiveData

    fun loadEpicDatesNatural() {
        repo.getAllEpicNatural {
            _naturalColorsLiveData.value = it
        }
    }

    fun loadEpicDatesEnhanced() {
        repo.getAllEpicEnhanced {
            _enhancedColorsLiveData.value = it
        }
    }

    fun loadEpicNaturalImages(date: String) {
        repo.getAllEpicNaturalByDate(date) {
            _epicImageLiveData.value = it
        }
    }

    fun loadEpicEnhancedImages(date: String) {
        repo.getAllEpicEnhancedByDate(date) {
            _epicImageLiveData.value = it
        }
    }

}