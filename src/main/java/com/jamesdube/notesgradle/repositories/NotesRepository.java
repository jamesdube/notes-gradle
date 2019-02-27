package com.jamesdube.notesgradle.repositories;


import com.jamesdube.notesgradle.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotesRepository extends JpaRepository<Note,Long>,
        JpaSpecificationExecutor<Note> {


}
