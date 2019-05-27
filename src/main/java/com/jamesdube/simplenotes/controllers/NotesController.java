package com.jamesdube.simplenotes.controllers;

import com.jamesdube.simplenotes.domain.Note;
import com.jamesdube.simplenotes.services.NoteService;
import com.jamesdube.simplenotes.utils.wrappers.NotesWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jamesdube.simplenotes.utils.wrappers.NotesWrapper.newInstance;

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
    public List<Note> index(@RequestParam(required = false) String text){

        NotesWrapper notesWrapper = generateWrapper(text);

        return noteService.search(notesWrapper);
    }

    private static NotesWrapper generateWrapper(String text){
        return newInstance(text);
    }
}
