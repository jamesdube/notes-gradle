package com.jamesdube.notesgradle.repositories;


import com.jamesdube.notesgradle.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note,Long>{
}
