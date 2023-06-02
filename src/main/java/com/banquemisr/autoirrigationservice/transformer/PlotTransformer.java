package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.PlotDto;
import com.banquemisr.autoirrigationservice.model.Plot;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlotTransformer implements BaseTransformer<Plot, PlotDto, PlotMapper> {
    private final PlotMapper plotMapper;

    @Override
    public PlotMapper getMapper() {
        return plotMapper;
    }
}
