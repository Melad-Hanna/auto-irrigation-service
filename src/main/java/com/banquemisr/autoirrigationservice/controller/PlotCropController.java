package com.banquemisr.autoirrigationservice.controller;

import com.banquemisr.autoirrigationservice.api.ApiResponse;
import com.banquemisr.autoirrigationservice.api.ApiResponseBuilder;
import com.banquemisr.autoirrigationservice.dto.PlotCropDto;
import com.banquemisr.autoirrigationservice.service.PLotCropService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PlotCropController implements BaseController<PLotCropService, PlotCropDto> {
    private final PLotCropService pLotCropService;
    private final ApiResponseBuilder apiResponseBuilder;

    @PutMapping("/api/v1/plot-crop/plot/{plotId}")
    public ApiResponse<PlotCropDto> updatePlotCrop(@PathVariable Long plotId, @Valid @RequestBody PlotCropDto plotCropDto) {
        return getApiResponseBuilder().buildApiSuccessResponse(getService().updatePlotCrop(plotId, plotCropDto));
    }

    @Override
    public PLotCropService getService() {
        return pLotCropService;
    }

    @Override
    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }
}
