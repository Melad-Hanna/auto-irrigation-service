package com.banquemisr.autoirrigationservice.controller;

import com.banquemisr.autoirrigationservice.api.ApiResponse;
import com.banquemisr.autoirrigationservice.api.ApiResponseBuilder;
import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.service.PLotCropService;
import com.banquemisr.autoirrigationservice.service.PlotSlotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@AllArgsConstructor
@Validated
public class PlotSlotController implements BaseController<PlotSlotService, PlotSlotDto> {
    private final PlotSlotService plotSlotService;
    private final ApiResponseBuilder apiResponseBuilder;

    @Override
    public PlotSlotService getService() {
        return plotSlotService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PutMapping("/api/v1/plot-slot/plot/{plotId}")
    public ApiResponse<Set<PlotSlotDto>> updatePlotSlots(@PathVariable Long plotId, @Valid @RequestBody Set<PlotSlotDto> plotSlotDtos) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().updatePlotSlots(plotId, plotSlotDtos));
    }
}
