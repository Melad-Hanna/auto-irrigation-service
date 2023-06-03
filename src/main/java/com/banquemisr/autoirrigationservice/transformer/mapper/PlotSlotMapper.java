package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.model.PlotSlot;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = BaseMapperConfig.class)
public interface PlotSlotMapper extends BaseMapper<PlotSlot, PlotSlotDto> {
}
