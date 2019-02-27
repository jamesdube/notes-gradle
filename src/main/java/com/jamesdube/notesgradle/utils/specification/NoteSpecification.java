package com.jamesdube.notesgradle.utils.specification;

import com.jamesdube.notesgradle.domain.Note;
import com.jamesdube.notesgradle.utils.criteria.NoteCriteriaBuilder;
import com.jamesdube.notesgradle.utils.wrappers.NotesWrapper;
import org.springframework.data.jpa.domain.Specification;

public class NoteSpecification {

    public static Specification<Note> filterByWrapper(NotesWrapper notesWrapper) {
        return (fromRoot, criteriaDefinition, criteriaBuilder)
                -> NoteCriteriaBuilder.getInstance().buildConjunctionPredicate(fromRoot, criteriaBuilder, notesWrapper);
    }
}
