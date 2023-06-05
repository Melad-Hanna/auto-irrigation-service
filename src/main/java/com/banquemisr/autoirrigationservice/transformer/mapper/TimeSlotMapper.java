package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.TimeSlotDto;
import com.banquemisr.autoirrigationservice.model.TimeSlot;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = BaseMapperConfig.class)
public interface TimeSlotMapper extends BaseMapper<TimeSlot, TimeSlotDto> {
}
