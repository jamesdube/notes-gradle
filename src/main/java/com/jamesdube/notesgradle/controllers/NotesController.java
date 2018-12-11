package com.jamesdube.notesgradle.controllers;

import com.jamesdube.notesgradle.domain.Note;
import com.jamesdube.notesgradle.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class NotesController {

    private NoteService noteService;

    public NotesController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(value = "/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note){
        return noteService.save(note);
    }

    @GetMapping(value = "/notes")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> index(){
        List<Note> notes =  noteService.all();

        for(Note note : notes){
            System.out.println("TEXT ===============> " + note.getText());
        }


        return notes;
    }
}
