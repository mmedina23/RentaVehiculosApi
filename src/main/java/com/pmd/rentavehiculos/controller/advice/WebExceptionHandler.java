package com.pmd.rentavehiculos.controller.advice;

import com.pmd.rentavehiculos.exception.ReglaNegocioExcepcion;
import com.pmd.rentavehiculos.model.ErrorDto;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class WebExceptionHandler {

    private Logger log = Logger.getLogger(WebExceptionHandler.class.getName());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handleGeneralException(Exception exception) {
        log.log(Level.SEVERE, String.format("internal_error_%s: %s", exception.getClass().getSimpleName(), exception.getMessage()), exception);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handleNullValueException(NullPointerException exception) {
        log.log(Level.SEVERE, "null_fatal_error", exception);
    }

    @ExceptionHandler(EmptyStackException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void handleEmptyStackException(EmptyStackException exception) {
        var message = "no content ".concat(exception.getLocalizedMessage());
        log.log(Level.INFO, message);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void handleNoSuchElementException(NoSuchElementException exception) {
        var message = "no_such_element_error: ".concat(exception.getLocalizedMessage());
        log.log(Level.INFO, message);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorDto handleConstraintViolationException(ConstraintViolationException exception) {
        var message = String.format("database_%s_error: %s", exception.getClass().getName(), exception.getMessage());
        log.log(Level.WARNING, message, exception);

        return new ErrorDto()
                .mensaje(exception.getMessage())
                .detalles(exception.getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage).toList());
    }

    @ExceptionHandler(ReglaNegocioExcepcion.class)
    ResponseEntity<ErrorDto> handleReglaNegocioExcepcion(ReglaNegocioExcepcion exception) {
        var message = "business_rule: ".concat(exception.getMessage());
        log.log(Level.WARNING, message, exception);

        return ResponseEntity.status(exception.responseCode)
                .body(new ErrorDto().mensaje(exception.getMessage()));
    }

    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handlePersistenceException(PersistenceException exception) {
        var message = "database_error: ".concat(exception.getLocalizedMessage());
        log.log(Level.SEVERE, message);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    void handleDataAccessException(DataAccessException exception) {
        var message = "database_error: ".concat(exception.getLocalizedMessage());
        log.log(Level.SEVERE, message);
    }

}
