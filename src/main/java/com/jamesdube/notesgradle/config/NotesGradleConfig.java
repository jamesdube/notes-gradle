package com.jamesdube.notesgradle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.jamesdube.notesgradle.controllers" })
public class NotesGradleConfig {
}
