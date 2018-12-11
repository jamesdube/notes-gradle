package com.jamesdube.notesgradle.config;

import com.jamesdube.notesgradle.repositories.NotesRepository;
import com.jamesdube.notesgradle.services.NoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.jamesdube.notesgradle" })
public class NotesGradleConfig {

    @Bean
    public NoteService noteService(NotesRepository notesRepository){
        return new NoteService(notesRepository);
    }
}
