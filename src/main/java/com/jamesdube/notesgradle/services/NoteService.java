package com.jamesdube.notesgradle.services;

import com.jamesdube.notesgradle.domain.Note;
import com.jamesdube.notesgradle.repositories.NotesRepository;

import java.util.List;

public class NoteService {

    private NotesRepository notesRepository;

    public NoteService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Note> create(List<Note> notes){
        return notesRepository.saveAll(notes);
    }

    public Note create(Note note){
        return save(note);
    }

    public Note save(Note note){
        return notesRepository.save(note);
    }

    public List<Note> all() {
        return notesRepository.findAll();
    }
}
