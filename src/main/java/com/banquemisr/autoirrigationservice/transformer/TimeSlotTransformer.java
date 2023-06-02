package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.PlotDto;
import com.banquemisr.autoirrigationservice.dto.TimeSlotDto;
import com.banquemisr.autoirrigationservice.model.Plot;
import com.banquemisr.autoirrigationservice.model.TimeSlot;
import com.banquemisr.autoirrigationservice.transformer.mapper.PlotMapper;
import com.banquemisr.autoirrigationservice.transformer.mapper.TimeSlotMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TimeSlotTransformer implements BaseTransformer<TimeSlot, TimeSlotDto, TimeSlotMapper> {
    private final TimeSlotMapper timeSlotMapper;

    @Override
    public TimeSlotMapper getMapper() {
        return timeSlotMapper;
    }
}
