package com.banquemisr.autoirrigationservice.api;

import com.banquemisr.autoirrigationservice.dto.BaseDto;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ApiResponseBuilder<Dto extends BaseDto> {
    // GENERIC BUILDERS
    ApiResponse<Dto> buildApiResponse(Dto dto, String message);

    ApiResponse<? extends Object> buildApiResponse(Object obj, String message);

    ApiResponse<List<Dto>> buildApiResponse(List<Dto> dtoList, String message);

    ApiResponse<Map<String, Map<String, Map<String, Dto>>>> buildApiResponse(Map<String, Map<String, Map<String, Dto>>> DTOsMap, String message);


    // BUILD SUCCESS
    ApiResponse<Dto> buildApiSuccessResponse();

    ApiResponse<Dto> buildApiSuccessResponse(String message);

    ApiResponse<Dto> buildApiSuccessResponse(Dto dto);

    ApiResponse<? extends Object> buildApiSuccessResponse(Object obj);

    ApiResponse<List<Dto>> buildApiSuccessResponse(List<Dto> dtoList);

    ApiResponse<Map<String, Map<String, Map<String, Dto>>>> buildApiSuccessResponse(Map<String, Map<String, Map<String, Dto>>> DTOsMap);


    // BUILD FAILURE
    ApiResponse<Dto> buildApiFailureResponse();

    ApiResponse<Dto> buildApiFailureResponse(String message);

    ApiResponse<Dto> buildApiFailureResponse(String message, String detailedMessages);

    ApiResponse<Dto> buildApiFailureResponse(Dto dto);

    ApiResponse<List<Dto>> buildApiFailureResponse(List<Dto> dtoList);

    ApiResponse<Dto> buildApiFailureResponse(List<FieldError> fieldErrors, List<ObjectError> objectErrors);

    ApiResponse<Dto> buildApiFailureResponse(Set<ConstraintViolation<?>> constraintViolations);
}
