package project.paveltoy.podapp.data.notedata

import project.paveltoy.podapp.data.entities.Note

class NoteRepoImpl: NoteRepo {
    private var noteList: ArrayList<Note> = arrayListOf()

    override fun saveNote(note: Note) {
        noteList.add(note)
    }

    override fun saveNotes(notes: ArrayList<Note>) {
        noteList = notes
    }

    override fun getNotes(): ArrayList<Note> {
        return noteList
    }

    override fun editNote(note: Note) {
        val index = noteList.indexOf(note)
        noteList[index] = note
    }

    override fun removeNote(note: Note) {
        noteList.remove(note)
    }
}