package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.PlotConfigDto;
import com.banquemisr.autoirrigationservice.dto.PlotCropDto;
import com.banquemisr.autoirrigationservice.model.PlotConfig;
import com.banquemisr.autoirrigationservice.model.PlotCrop;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotConfigMapper;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotCropMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlotCropTransformer implements BaseTransformer<PlotCrop, PlotCropDto, PlotCropMapper> {
    private final PlotCropMapper plotCropMapper;

    @Override
    public PlotCropMapper getMapper() {
        return plotCropMapper;
    }
}
