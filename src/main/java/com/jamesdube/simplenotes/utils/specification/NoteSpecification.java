package com.jamesdube.simplenotes.utils.specification;

import com.jamesdube.simplenotes.domain.Note;
import com.jamesdube.simplenotes.utils.criteria.NoteCriteriaBuilder;
import com.jamesdube.simplenotes.utils.wrappers.NotesWrapper;
import org.springframework.data.jpa.domain.Specification;

public class NoteSpecification {

    public static Specification<Note> filterByWrapper(NotesWrapper notesWrapper) {
        return (fromRoot, criteriaDefinition, criteriaBuilder)
                -> NoteCriteriaBuilder.getInstance().buildConjunctionPredicate(fromRoot, criteriaBuilder, notesWrapper);
    }
}
