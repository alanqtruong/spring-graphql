package com.example.spring.graph.ql.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author alanqtruong
 */
public class ServiceException extends RuntimeException {

    private final HttpStatus httpStatus;

    public ServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
