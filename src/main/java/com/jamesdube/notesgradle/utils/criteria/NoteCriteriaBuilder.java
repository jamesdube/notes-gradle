package com.jamesdube.notesgradle.utils.criteria;

import com.jamesdube.notesgradle.domain.Note;
import com.jamesdube.notesgradle.utils.wrappers.NotesWrapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class NoteCriteriaBuilder {

    private static NoteCriteriaBuilder instance;
    private final CriteriaUtils<Note> criteriaUtils = new CriteriaUtils<>();

    public static NoteCriteriaBuilder getInstance() {
        if (instance == null) {
            instance = new NoteCriteriaBuilder();
        }
        return instance;
    }

    /*private static void resetStatusAllValues(final NotesWrapper wrapper) {
        if (Constants.STATUS_ALL.equalsIgnoreCase(wrapper.getStatus())) {
            wrapper.setStatus(null);
        }
    }*/

    public Predicate buildConjunctionPredicate(final Root<Note> root, final CriteriaBuilder criteriaBuilder, final NotesWrapper wrapper) {
        Predicate predicate = criteriaBuilder.conjunction();
        if (wrapper == null) {
            return buildAllRecordsConjunctionPredicate(predicate, root, criteriaBuilder);
        }
        //resetStatusAllValues(wrapper);
        return buildEntitySpecificConjunctionPredicateForProvider(predicate, root, criteriaBuilder, wrapper);
    }

    private Predicate buildAllRecordsConjunctionPredicate(final Predicate conjunctionPredicate, final Root<Note> fromRoot, final CriteriaBuilder criteriaBuilder) {
//        final Status statusValue = Status.DELETED;
        return criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.isNotEmpty(fromRoot.get("id")));
    }

    private Predicate buildEntitySpecificConjunctionPredicateForProvider(final Predicate conjunctionPredicate, final Root<Note> fromRoot, final CriteriaBuilder criteriaBuilder, NotesWrapper wrapper) {

        Predicate entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.equal(fromRoot.get("id"), wrapper.getId()), wrapper.getId());

        if (wrapper.getText() != null) {
            entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(entityConjunctionPredicate, criteriaBuilder,
                    criteriaBuilder.equal(fromRoot.get("text"), wrapper.getText()), wrapper.getText());
        }

        return entityConjunctionPredicate;

    }

}
