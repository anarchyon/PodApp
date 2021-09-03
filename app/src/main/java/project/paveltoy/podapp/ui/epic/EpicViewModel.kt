package project.paveltoy.podapp.ui.epic

import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.DataRepo
import project.paveltoy.podapp.data.DataRepoImpl

class EpicViewModel(
    private val repo: DataRepo = DataRepoImpl()
): ViewModel() {


    fun loadEpicDatesNatural() {
        repo.getAllEpicNatural()
    }

    fun loadEpicDatesEnhanced() {
        repo.getAllEpicEnhanced()
    }
}