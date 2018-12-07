package com.jamesdube.notesgradle.controllers;

import com.jamesdube.notesgradle.domain.Note;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class NotesController {

    @PostMapping(value = "/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note){
        return note;
    }

    @GetMapping(value = "/notes")
    @ResponseStatus(HttpStatus.OK)
    public List<Note> index(){
        return Arrays.asList(new Note(1L,"my first note"),new Note(2L,"a random note"));
    }
}
