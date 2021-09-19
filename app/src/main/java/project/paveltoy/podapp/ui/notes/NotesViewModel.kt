package project.paveltoy.podapp.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.entities.Note
import project.paveltoy.podapp.data.notedata.NoteRepo
import project.paveltoy.podapp.data.notedata.NoteRepoImpl

class NotesViewModel: ViewModel() {
    private val noteRepo: NoteRepo = NoteRepoImpl()
    val selectedNoteLiveData = MutableLiveData<Note?>()
    val noteListLiveData = MutableLiveData<List<Note>>()
    val savedNoteLiveData = MutableLiveData<Note>()

    fun setSelectedNote(note: Note) {
        selectedNoteLiveData.value = note
    }

    fun cleanSelect() {
        selectedNoteLiveData.value = null
    }

    fun loadNotes(): List<Note> {
        return noteRepo.getNotes()
    }

    fun saveNote(note: Note) {
        noteRepo.saveNote(note)
        noteListLiveData.value = noteRepo.getNotes()
        savedNoteLiveData.value = note
    }
}