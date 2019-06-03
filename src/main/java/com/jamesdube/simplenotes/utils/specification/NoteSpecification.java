package com.jamesdube.simplenotes.utils.specification;

import com.jamesdube.simplenotes.domain.Note;
import com.jamesdube.simplenotes.utils.wrappers.NotesWrapper;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class NoteSpecification {

    public static Specification<Note> filterByWrapper(NotesWrapper notesWrapper) {

        return (Specification<Note>) (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            /*if(notesWrapper.getId() != null){
                Predicate p = criteriaBuilder.equal(root.get("id"), notesWrapper.getId());
                predicates.add(p);
            }*/

            if(notesWrapper.getText() != null){
                Predicate p = criteriaBuilder.equal(root.get("text"), notesWrapper.getText());
                predicates.add(p);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
