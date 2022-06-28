package com.sample.surveydemo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record OfferException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
}
