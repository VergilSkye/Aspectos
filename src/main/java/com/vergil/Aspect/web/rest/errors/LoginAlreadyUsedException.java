package com.vergil.Aspect.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class LoginAlreadyUsedException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public LoginAlreadyUsedException() {
        super(ErrorConstants.LOGIN_ALREADY_USED_TYPE, "Login name already used!", Status.BAD_REQUEST);
    }
}
