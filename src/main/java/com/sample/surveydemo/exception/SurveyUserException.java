package com.sample.surveydemo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record SurveyUserException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
}
