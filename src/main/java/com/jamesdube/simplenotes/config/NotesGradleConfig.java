package com.jamesdube.simplenotes.config;

import com.jamesdube.simplenotes.repositories.NotesRepository;
import com.jamesdube.simplenotes.services.NoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.jamesdube.simplenotes" })
public class NotesGradleConfig {

    @Bean
    public NoteService noteService(NotesRepository notesRepository){
        return new NoteService(notesRepository);
    }
}
