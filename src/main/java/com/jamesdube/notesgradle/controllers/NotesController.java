package com.jamesdube.notesgradle.controllers;

import com.jamesdube.notesgradle.domain.Note;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotesController {

    @PostMapping(value = "/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note){
        return note;
    }
}
