package com.example.sensorapp.rest.model;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class ApiErrorDtoFactory {

    private ApiErrorDtoFactory() {
    }

    public static ApiErrorDto of(HttpStatus status, String message, WebRequest request) {
        return new ApiErrorDto(
                status.value(),
                message,
                LocalDateTime.now(),
                getMethod(request),
                getPath(request)
        );
    }

    public static ApiErrorDto of(HttpStatus status, MethodArgumentNotValidException ex, WebRequest request) {
        var errorResponse = new ApiErrorDto(
                status.value(),
                "Validation Error",
                LocalDateTime.now(),
                getMethod(request),
                getPath(request)
        );

        var validationErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(e ->
                        new ApiErrorDto.ValidationError(
                                e.getField(),
                                e.getDefaultMessage(),
                                e.getRejectedValue() != null ? e.getRejectedValue().toString() : null)

                ).collect(Collectors.toList());

        errorResponse.getErrors().addAll(validationErrors);
        return errorResponse;
    }

    public static ApiErrorDto of(HttpStatus status, ConstraintViolationException ex, WebRequest request) {
        var errorResponse = new ApiErrorDto(
                status.value(),
                "Validation Error",
                LocalDateTime.now(),
                getMethod(request),
                getPath(request)
        );

        var validationErrors = ex.getConstraintViolations().stream()
                .map(e ->
                        new ApiErrorDto.ValidationError(
                                e.getPropertyPath().toString(),
                                e.getMessage(),
                                e.getInvalidValue().toString())

                ).collect(Collectors.toList());

        errorResponse.getErrors().addAll(validationErrors);
        return errorResponse;
    }

    private static String getPath(WebRequest request) {
        var url = ((ServletWebRequest) request).getRequest().getRequestURI();
        return url.substring(url.indexOf('/'));
    }

    private static String getMethod(WebRequest request) {
        ServletWebRequest req = (ServletWebRequest) request;
        if (req.getHttpMethod() == null) {
            return null;
        } else {
            return req.getHttpMethod().name();
        }
    }
}
