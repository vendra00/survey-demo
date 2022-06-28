package com.sample.surveydemo.exception;

import java.io.Serial;

public class OfferRequestException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public OfferRequestException(String message) {
        super(message);
    }

    public OfferRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
