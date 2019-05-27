package com.jamesdube.simplenotes.utils.criteria;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.Date;

public class CriteriaUtils<T> {

        public void updateParameters(final String parameterName, TypedQuery<T> query, final String value, final boolean upperCase) {
            final boolean canUpdate = StringUtils.isNotEmpty(value);
            if (canUpdate) {
                query.setParameter(parameterName, upperCase ? value.trim().toUpperCase() : value.trim());
            }
        }

        public void updateParameters(final String parameterName, TypedQuery<T> query, final Long value) {
            final boolean canUpdate = value != null;
            if (canUpdate) {
                query.setParameter(parameterName, value);
            }
        }

        public void updateParameters(final String parameterName, final TypedQuery<T> query, final Date value, final TemporalType temporalType) {
            final boolean canUpdate = value != null;
            if (canUpdate) {
                query.setParameter(parameterName, value, temporalType);
            }
        }

        public Predicate buildConjunctionPredicate(Predicate conjunctionPredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final String value) {
            final boolean canBuild = StringUtils.isNotEmpty(value);
            if (canBuild) {
                return criteriaBuilder.and(conjunctionPredicate, expression);
            }
            return conjunctionPredicate;
        }

        public Predicate buildConjunctionPredicate(Predicate conjunctionPredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final Date value) {
            final boolean canBuild = value != null;
            if (canBuild) {
                return criteriaBuilder.and(conjunctionPredicate, expression);
            }
            return conjunctionPredicate;
        }

        public Predicate buildConjunctionPredicate(Predicate conjunctionPredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final Long value) {
            final boolean canBuild = value != null;
            if (canBuild) {
                return criteriaBuilder.and(conjunctionPredicate, expression);
            }
            return conjunctionPredicate;
        }

        public Predicate buildConjunctionPredicate(Predicate conjunctionPredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final Double value) {
            final boolean canBuild = value != null;
            if (canBuild) {
                return criteriaBuilder.and(conjunctionPredicate, expression);
            }
            return conjunctionPredicate;
        }

        public Predicate buildConjunctionPredicate(Predicate conjunctionPredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final boolean value) {
            final boolean canBuild = value;
            if (canBuild) {
                return criteriaBuilder.and(conjunctionPredicate, expression);
            }
            return conjunctionPredicate;
        }

        public Predicate buildConjunctionPredicate(Predicate conjunctionPredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression) {
            return criteriaBuilder.and(conjunctionPredicate, expression);
        }

        public String addLikeWildCards(final String value, final boolean upperCase) {
            if (StringUtils.isEmpty(value)) {
                return value;
            }
            return "*" + (upperCase ? value.trim().toUpperCase() : value.trim()) + "*";
        }

        public Predicate buildDisjunctivePredicate(Predicate disjunctivePredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final String value) {
            final boolean canBuild = StringUtils.isNotEmpty(value);
            if (canBuild) {
                return criteriaBuilder.or(disjunctivePredicate, expression);
            }
            return disjunctivePredicate;
        }

        public Predicate buildDisjunctivePredicate(Predicate disjunctivePredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final Date value) {
            final boolean canBuild = value != null;
            if (canBuild) {
                return criteriaBuilder.or(disjunctivePredicate, expression);
            }
            return disjunctivePredicate;
        }

        public Predicate buildDisjunctivePredicate(Predicate disjunctivePredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final Long value) {
            final boolean canBuild = value != null;
            if (canBuild) {
                return criteriaBuilder.or(disjunctivePredicate, expression);
            }
            return disjunctivePredicate;
        }

        public Predicate buildDisjunctivePredicate(Predicate disjunctivePredicate, final CriteriaBuilder criteriaBuilder, Expression<Boolean> expression, final Double value) {
            final boolean canBuild = value != null;
            if (canBuild) {
                return criteriaBuilder.or(disjunctivePredicate, expression);
            }
            return disjunctivePredicate;
        }
    }