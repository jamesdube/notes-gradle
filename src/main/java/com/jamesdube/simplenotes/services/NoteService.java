package com.jamesdube.simplenotes.services;

import com.jamesdube.simplenotes.domain.Note;
import com.jamesdube.simplenotes.repositories.NotesRepository;
import com.jamesdube.simplenotes.utils.specification.NoteSpecification;
import com.jamesdube.simplenotes.utils.wrappers.NotesWrapper;

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

    public List<Note> search(NotesWrapper notesWrapper){

        return notesRepository.findAll(NoteSpecification.filterByWrapper(notesWrapper));

    }
}
