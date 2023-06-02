package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.PlotConfigDto;
import com.banquemisr.autoirrigationservice.model.PlotConfig;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotConfigMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlotConfigTransformer implements BaseTransformer<PlotConfig, PlotConfigDto, PlotConfigMapper> {
    private final PlotConfigMapper plotConfigMapper;

    @Override
    public PlotConfigMapper getMapper() {
        return plotConfigMapper;
    }
}
