package com.jamesdube.notesgradle.services;

import com.jamesdube.notesgradle.domain.Note;
import com.jamesdube.notesgradle.repositories.NotesRepository;
import com.jamesdube.notesgradle.utils.specification.NoteSpecification;
import com.jamesdube.notesgradle.utils.wrappers.NotesWrapper;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.stream.Stream;

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
