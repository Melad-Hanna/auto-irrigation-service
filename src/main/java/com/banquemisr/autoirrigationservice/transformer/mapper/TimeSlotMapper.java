package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.PlotConfigDto;
import com.banquemisr.autoirrigationservice.model.PlotConfig;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = BaseMapperConfig.class)
public interface TimeSlotMapper extends BaseMapper<PlotConfig, PlotConfigDto> {
}
