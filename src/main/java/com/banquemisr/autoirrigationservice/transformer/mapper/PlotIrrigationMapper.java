package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.PlotIrrigationDto;
import com.banquemisr.autoirrigationservice.model.PlotIrrigation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = BaseMapperConfig.class)
public interface PlotIrrigationMapper extends BaseMapper<PlotIrrigation, PlotIrrigationDto> {
}
