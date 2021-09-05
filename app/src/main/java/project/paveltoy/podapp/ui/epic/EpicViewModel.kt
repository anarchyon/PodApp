package project.paveltoy.podapp.ui.epic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.DataRepo
import project.paveltoy.podapp.data.DataRepoImpl
import project.paveltoy.podapp.data.entities.EpicDay

class EpicViewModel(
    private val repo: DataRepo = DataRepoImpl()
): ViewModel() {
    private var _naturalColorsLiveData = MutableLiveData<List<EpicDay>>()
    val naturalColorsLiveData get() = _naturalColorsLiveData

    fun loadEpicDatesNatural() {
        repo.getAllEpicNatural {
            _naturalColorsLiveData.value = it
        }
    }

    fun loadEpicDatesEnhanced() {
        repo.getAllEpicEnhanced()
    }
}