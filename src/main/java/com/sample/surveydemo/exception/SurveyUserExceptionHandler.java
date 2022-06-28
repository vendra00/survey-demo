package com.sample.surveydemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class SurveyUserExceptionHandler {

    @ExceptionHandler(value = {SurveyUserRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(SurveyUserRequestException e) {
        // Create a payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ZonedDateTime timeZone = ZonedDateTime.now(ZoneId.of("Z"));
        SurveyUserException surveyUserException = new SurveyUserException(e.getMessage(), badRequest, timeZone);
        // Returns response entity
        return new ResponseEntity<>(surveyUserException, badRequest);
    }
}
