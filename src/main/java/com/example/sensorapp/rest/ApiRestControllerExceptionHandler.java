package com.example.sensorapp.rest;


import com.example.sensorapp.rest.model.ApiErrorDto;
import com.example.sensorapp.rest.model.ApiErrorDtoFactory;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestControllerAdvice
public class ApiRestControllerExceptionHandler
        extends ResponseEntityExceptionHandler {

    /**
     * Default fall back
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ApiErrorDto fallBackHandleException(
            Exception ex, WebRequest request) {

        log.warn(request.toString());
        return  ApiErrorDtoFactory.of(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", request);

    }


    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ApiErrorDto hanldeConstraintViolationException(
            ConstraintViolationException ex, WebRequest request) {

        log.warn(request.toString());
        return  ApiErrorDtoFactory.of(HttpStatus.BAD_REQUEST, ex, request);
    }



}
