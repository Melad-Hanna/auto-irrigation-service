package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.model.PlotSlot;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotSlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlotSlotTransformer implements BaseTransformer<PlotSlot, PlotSlotDto, PlotSlotMapper> {
    private final PlotSlotMapper plotSlotMapper;

    @Override
    public PlotSlotMapper getMapper() {
        return plotSlotMapper;
    }
}
