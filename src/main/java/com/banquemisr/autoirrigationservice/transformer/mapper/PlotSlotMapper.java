package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.PlotSlotDto;
import com.banquemisr.autoirrigationservice.model.PlotSlot;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = BaseMapperConfig.class)
public interface PlotSlotMapper extends BaseMapper<PlotSlot, PlotSlotDto> {

    @Override
    @Mapping(target = "plotCrop.id", source = "plotCropId")
    PlotSlot dtoToEntity(PlotSlotDto dto);

    @Override
    @Mapping(target = "plotCrop", ignore = true)
    @Mapping(target = "timeSlot", ignore = true)
    void updateEntity(PlotSlotDto dto, @MappingTarget PlotSlot entity);
}
