package com.banquemisr.autoirrigationservice.api;

import com.banquemisr.autoirrigationservice.constant.MessagesConstants;
import com.banquemisr.autoirrigationservice.dto.BaseDto;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.util.*;

@Component
public class ApiResponseBuilderImpl<Dto extends BaseDto> implements ApiResponseBuilder<Dto> {

    @Override
    public ApiResponse<Dto> buildApiResponse(Dto dto, String message) {
        return ApiResponse.<Dto>builder().message(message).response(dto).build();
    }

    @Override
    public ApiResponse<?> buildApiResponse(Object obj, String message) {
        return ApiResponse.builder().message(message).response(obj).build();
    }

    @Override
    public ApiResponse<List<Dto>> buildApiResponse(List<Dto> dtoList, String message) {
        return ApiResponse.<List<Dto>>builder().message(message).response(dtoList).build();
    }


    @Override
    public ApiResponse<Dto> buildApiSuccessResponse() {
        return buildApiSuccessResponse(MessagesConstants.REQUEST_SUCCESS);
    }


    @Override
    public ApiResponse<Dto> buildApiSuccessResponse(String message) {
        return ApiResponse.<Dto>builder().message(message).build();
    }

    @Override
    public ApiResponse<Dto> buildApiSuccessResponse(Dto dto) {
        return buildApiResponse(dto, MessagesConstants.REQUEST_SUCCESS);
    }

    @Override
    public ApiResponse<?> buildApiSuccessResponse(Object obj) {
        return buildApiResponse(obj, MessagesConstants.REQUEST_SUCCESS);
    }

    @Override
    public ApiResponse<List<Dto>> buildApiSuccessResponse(List<Dto> dtoList) {
        return buildApiResponse(dtoList, MessagesConstants.REQUEST_SUCCESS);
    }

    @Override
    public ApiResponse<Dto> buildApiFailureResponse() {
        return buildApiFailureResponse(MessagesConstants.REQUEST_FAILED);
    }

    @Override
    public ApiResponse<Dto> buildApiFailureResponse(String message) {
        return ApiResponse.<Dto>builder().message(message).build();
    }

    @Override
    public ApiResponse<Dto> buildApiFailureResponse(String message, String debugMessage) {
        return ApiResponse.<Dto>builder().message(message).debugMessage(debugMessage).build();
    }

    @Override
    public ApiResponse<Dto> buildApiFailureResponse(Dto dto) {
        return buildApiResponse(dto, MessagesConstants.REQUEST_FAILED);
    }

    @Override
    public ApiResponse<List<Dto>> buildApiFailureResponse(List<Dto> dtoList) {
        return buildApiResponse(dtoList, MessagesConstants.REQUEST_FAILED);
    }

    @Override
    public ApiResponse<Map<String, Map<String, Map<String, Dto>>>> buildApiResponse(Map<String, Map<String, Map<String, Dto>>> DTOsMap, String message) {
        return ApiResponse.<Map<String, Map<String, Map<String, Dto>>>>builder().message(message).response(DTOsMap).build();
    }

    @Override
    public ApiResponse<Map<String, Map<String, Map<String, Dto>>>> buildApiSuccessResponse(Map<String, Map<String, Map<String, Dto>>> DTOsMap) {
        return buildApiResponse(DTOsMap, MessagesConstants.REQUEST_SUCCESS);
    }

    @Override
    public ApiResponse<Dto> buildApiFailureResponse(List<FieldError> fieldErrors, List<ObjectError> objectErrors) {
        Map<String, Set<String>> errors = addValidationErrors(fieldErrors, objectErrors);
        return ApiResponse.<Dto>builder()
                .message(MessagesConstants.VALIDATION_ERROR)
                .errors(errors)
                .build();
    }

    @Override
    public ApiResponse<Dto> buildApiFailureResponse(Set<ConstraintViolation<?>> constraintViolations) {
        Map<String, Set<String>> errors = addValidationErrors(constraintViolations);
        return ApiResponse.<Dto>builder()
                .message(MessagesConstants.VALIDATION_ERROR)
                .errors(errors)
                .build();
    }

    private Map<String, Set<String>> addValidationErrors(List<FieldError> fieldErrors, List<ObjectError> objectErrors) {
        Map<String, Set<String>> errors = new HashMap<>();
        fieldErrors.forEach(fieldError -> addValidationError(fieldError.getField(), fieldError.getDefaultMessage(), errors));
        objectErrors.forEach(objectError -> addValidationError(objectError.getObjectName(), objectError.getDefaultMessage(), errors));
        return errors;
    }

    private Map<String, Set<String>> addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
        Map<String, Set<String>> errors = new HashMap<>();
        constraintViolations.forEach(cv -> addValidationError(((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
                cv.getMessage(), errors));
        return errors;
    }

    private void addValidationError(String name, String message, Map<String, Set<String>> errors) {
        if (errors.get(name) != null) {
            errors.get(name).add(message);
        } else {
            Set<String> subErrors = new HashSet<>();
            errors.put(name, subErrors);
            subErrors.add(message);
        }
    }
}
