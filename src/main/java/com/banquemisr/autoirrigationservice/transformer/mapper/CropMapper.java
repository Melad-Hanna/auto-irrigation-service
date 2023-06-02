package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.CropDto;
import com.banquemisr.autoirrigationservice.model.Crop;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        config = BaseMapperConfig.class)
public interface CropMapper extends BaseMapper<Crop, CropDto> {
}
