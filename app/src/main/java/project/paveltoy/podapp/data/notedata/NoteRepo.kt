package project.paveltoy.podapp.data.notedata

import project.paveltoy.podapp.data.entities.Note

interface NoteRepo {
    fun saveNote(note: Note)
    fun getNotes(): List<Note>
    fun editNote(note: Note)
}