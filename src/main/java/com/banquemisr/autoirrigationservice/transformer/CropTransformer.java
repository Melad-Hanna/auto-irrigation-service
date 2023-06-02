package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.CropDto;
import com.banquemisr.autoirrigationservice.dto.PlotConfigDto;
import com.banquemisr.autoirrigationservice.model.Crop;
import com.banquemisr.autoirrigationservice.model.PlotConfig;
import com.banquemisr.autoirrigationservice.transformer.mapper.CropMapper;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotConfigMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CropTransformer implements BaseTransformer<Crop, CropDto, CropMapper> {
    private final CropMapper cropMapper;

    @Override
    public CropMapper getMapper() {
        return cropMapper;
    }
}
