package com.example.spring.graph.ql.exceptions;

import com.example.spring.graph.ql.models.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Handle Exceptions
 *
 * @author alanqtruong
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlers {

    private static final String ERROR_MESSAGE = "Exception occurred";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ResponseMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        log.error(ERROR_MESSAGE, ex);
        return new ResponseEntity<>(new ResponseMessage(ex.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(". ")), new Date()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ResponseMessage> handleConstraintViolationException(
            ConstraintViolationException ex) {
        log.error(ERROR_MESSAGE, ex);
        return new ResponseEntity<>(new ResponseMessage(ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(". ")), new Date()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public final ResponseEntity<ResponseMessage> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        log.error(ERROR_MESSAGE, ex);
        return new ResponseEntity<>(new ResponseMessage(ex.getMessage(), new Date()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<ResponseMessage> handleUserNotFoundException(
            ServiceException ex) {
        log.error(ERROR_MESSAGE, ex);
        return new ResponseEntity<>(new ResponseMessage(ex.getMessage(), new Date()),
                ex.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ResponseMessage> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex) {
        log.error(ERROR_MESSAGE, ex);
        return new ResponseEntity<>(new ResponseMessage("Bad JSON Request", new Date()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseMessage> handleAllExceptions(Exception ex) {
        log.error(ERROR_MESSAGE, ex);
        return new ResponseEntity<>(
                new ResponseMessage("An error has occurred. Please try again later", new Date()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
