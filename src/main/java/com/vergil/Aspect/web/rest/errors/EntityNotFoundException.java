package com.vergil.Aspect.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class EntityNotFoundException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException() {
        super(ErrorConstants.ENTITY_NOT_FOUND_TYPE, "Entity Not Found, invalid argument", Status.BAD_REQUEST);
    }
}
