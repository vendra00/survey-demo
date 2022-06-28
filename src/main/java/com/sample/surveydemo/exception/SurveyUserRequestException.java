package com.sample.surveydemo.exception;

import java.io.Serial;

public class SurveyUserRequestException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public SurveyUserRequestException(String message) {
        super(message);
    }

    public SurveyUserRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
