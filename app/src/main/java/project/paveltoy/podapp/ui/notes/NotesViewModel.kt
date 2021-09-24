package project.paveltoy.podapp.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.data.entities.Note
import project.paveltoy.podapp.data.notedata.NoteRepo
import project.paveltoy.podapp.data.notedata.NoteRepoImpl

class NotesViewModel : ViewModel() {
    private val noteRepo: NoteRepo = NoteRepoImpl()
    val selectedNoteLiveData = MutableLiveData<Note?>()
    val noteListLiveData = MutableLiveData<List<Note>>()
    val savedNotePositionLiveData = MutableLiveData<Int>()

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
        if (noteRepo.getNotes().contains(note)) {
            noteRepo.editNote(note)
        } else {
            noteRepo.saveNote(note)
            noteListLiveData.value = noteRepo.getNotes()
        }
        savedNotePositionLiveData.value = noteRepo.getNotes().indexOf(note)
    }

    fun deleteNote(note: Note) {
        noteRepo.removeNote(note)
    }

    fun swapNotes(fromPosition: Int, toPosition: Int) {
        val notes: ArrayList<Note> = noteRepo.getNotes()
        val movedNote = notes[fromPosition]
        notes.remove(movedNote)
        notes.add(toPosition, movedNote)
        noteRepo.saveNotes(notes)
    }
}