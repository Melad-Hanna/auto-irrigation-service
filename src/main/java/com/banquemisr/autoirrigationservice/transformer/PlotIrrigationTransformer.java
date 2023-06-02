package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.PlotDto;
import com.banquemisr.autoirrigationservice.dto.PlotIrrigationDto;
import com.banquemisr.autoirrigationservice.model.Plot;
import com.banquemisr.autoirrigationservice.model.PlotIrrigation;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotIrrigationMapper;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlotIrrigationTransformer implements BaseTransformer<PlotIrrigation, PlotIrrigationDto, PlotIrrigationMapper> {
    private final PlotIrrigationMapper plotIrrigationMapper;

    @Override
    public PlotIrrigationMapper getMapper() {
        return plotIrrigationMapper;
    }
}
