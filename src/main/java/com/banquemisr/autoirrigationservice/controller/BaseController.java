package com.banquemisr.autoirrigationservice.controller;

import com.banquemisr.autoirrigationservice.api.ApiResponseBuilder;
import com.banquemisr.autoirrigationservice.dto.BaseDto;
import com.banquemisr.autoirrigationservice.service.BaseService;

public interface BaseController<Service extends BaseService, Dto extends BaseDto> {
    Service getService();

    ApiResponseBuilder getApiResponseBuilder();
}
