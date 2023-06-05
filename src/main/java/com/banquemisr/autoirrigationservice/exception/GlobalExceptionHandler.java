package com.banquemisr.autoirrigationservice.exception;

import com.banquemisr.autoirrigationservice.api.ApiResponse;
import com.banquemisr.autoirrigationservice.api.ApiResponseBuilder;
import com.banquemisr.autoirrigationservice.constant.MessagesConstants;
import com.banquemisr.autoirrigationservice.exception.custom.BusinessException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final ApiResponseBuilder apiResponseBuilder;

    public GlobalExceptionHandler(ApiResponseBuilder apiResponseBuilder) {
        this.apiResponseBuilder = apiResponseBuilder;
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity handleBusinessError(BusinessException ex) {
        logger.error("Exception Occurred", ex);
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(ex.getMessage(), ex.getDebugMessage()), BAD_REQUEST);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                          HttpStatus status,
                                                          WebRequest request) {
        logger.error("Exception Occurred", ex);
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(ex.getBindingResult().getFieldErrors(),
                ex.getBindingResult().getGlobalErrors()), BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        logger.error("Exception Occurred", ex);
        String message = String.format(MessagesConstants.PARAMETER_MISMATCH, ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(message,
                ex.getLocalizedMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    protected ResponseEntity handleConstraintViolation(javax.validation.ConstraintViolationException ex) {
        logger.error("Exception Occurred", ex);
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(ex.getConstraintViolations()), BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity handleEntityNotFound(EntityNotFoundException ex) {
        logger.error("Exception Occurred", ex);
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(ex.getLocalizedMessage()), OK);
    }


    @Override
    protected ResponseEntity handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                          HttpHeaders headers, HttpStatus status,
                                                          WebRequest request) {
        logger.error("Exception Occurred", ex);
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(
                MessagesConstants.MALFORMED_JSON_REQUEST, ex.getLocalizedMessage()), BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        logger.error("Exception Occurred", ex);
        if (ex.getCause() instanceof ConstraintViolationException constraintException) {
            try {
                String constrainMessage = constraintException.getConstraintName();
                if (!constrainMessage.equals(""))
                    return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(
                            constrainMessage, ex.getLocalizedMessage()), CONFLICT);

            } catch (NoSuchElementException ignored) {
            }
            return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(
                    constraintException.getConstraintName(), ex.getLocalizedMessage()), CONFLICT);
        }
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(
                MessagesConstants.DATABASE_ERROR, ex.getLocalizedMessage()), INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity handleConstrainException(TransactionSystemException ex) {
        logger.error("Exception Occurred", ex);
        if (ex.getRootCause() instanceof javax.validation.ConstraintViolationException constraintViolationException) {
            return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(constraintViolationException.getConstraintViolations()), BAD_REQUEST);
        }
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(MessagesConstants.TRANSACTION_SYSTEM_ERROR,
                ex.getLocalizedMessage()), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllExceptions(Exception ex) {
        logger.error("Exception Occurred", ex);
        return buildResponseEntity(this.apiResponseBuilder.buildApiFailureResponse(
                MessagesConstants.UNEXPECTED_ERROR,
                ex.getLocalizedMessage()), INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiResponse> buildResponseEntity(ApiResponse apiResponse, HttpStatus code) {
        return new ResponseEntity<ApiResponse>(apiResponse, code);
    }
}
