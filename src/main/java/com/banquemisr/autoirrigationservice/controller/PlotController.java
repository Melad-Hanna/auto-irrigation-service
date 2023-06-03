package com.banquemisr.autoirrigationservice.controller;

import com.banquemisr.autoirrigationservice.api.ApiResponse;
import com.banquemisr.autoirrigationservice.api.ApiResponseBuilder;
import com.banquemisr.autoirrigationservice.dto.PlotDto;
import com.banquemisr.autoirrigationservice.service.PlotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class PlotController implements BaseController<PlotService, PlotDto> {
    private final PlotService plotService;
    private final ApiResponseBuilder apiResponseBuilder;

    @PostMapping("/api/v1/plot")
    public ApiResponse<PlotDto> create(@Valid @RequestBody PlotDto plotDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().create(plotDto));
    }

    @PutMapping("/api/v1/plot/{id}")
    public ApiResponse<PlotDto> update(@PathVariable Long id, @Valid @RequestBody PlotDto plotDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().update(plotDto, id));
    }

    @GetMapping("/api/v1/plot")
    public ApiResponse<List<PlotDto>> findAll() {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findAll(false));
    }

    @GetMapping("/api/v1/plot/{id}")
    public ApiResponse<PlotDto> findById(@PathVariable Long id) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().findById(id));
    }

    @Override
    public PlotService getService() {
        return plotService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
