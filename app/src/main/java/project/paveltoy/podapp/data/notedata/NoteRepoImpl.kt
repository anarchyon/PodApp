package project.paveltoy.podapp.data.notedata

import project.paveltoy.podapp.data.entities.Note

class NoteRepoImpl: NoteRepo {
    private val noteList: ArrayList<Note> = arrayListOf()

    override fun saveNote(note: Note) {
        noteList.add(note)
    }

    override fun getNotes(): List<Note> {
        return noteList
    }

    override fun editNote(note: Note) {

    }
}