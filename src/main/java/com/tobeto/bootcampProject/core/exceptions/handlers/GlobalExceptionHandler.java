package com.tobeto.bootcampProject.core.exceptions.handlers;

import com.tobeto.bootcampProject.core.exceptions.problemdetails.BusinessProblemDetails;
import com.tobeto.bootcampProject.core.exceptions.problemdetails.InternalServerErrorProblemDetails;
import com.tobeto.bootcampProject.core.exceptions.problemdetails.ValidationProblemDetails;
import com.tobeto.bootcampProject.core.exceptions.types.BusinessException;
import com.tobeto.bootcampProject.core.exceptions.types.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBussinessException(BusinessException businessException) {
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(businessException.getMessage());

        return businessProblemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().stream()
                .map(error -> validationErrors.put(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);

        return validationProblemDetails;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalServerErrorProblemDetails handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        InternalServerErrorProblemDetails serverErrorProblemDetails = new InternalServerErrorProblemDetails();
        serverErrorProblemDetails.setDetail(exception.getMessage());

        return serverErrorProblemDetails;
    }
}