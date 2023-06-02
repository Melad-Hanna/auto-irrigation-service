package com.banquemisr.autoirrigationservice.transformer.mapper;

import com.banquemisr.autoirrigationservice.dto.BaseDto;
import com.banquemisr.autoirrigationservice.model.BaseEntity;
import org.mapstruct.*;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface BaseMapperConfig {

    @Mappings({
            @Mapping(target = "createdDate", ignore = true),
            @Mapping(target = "modifiedDate", ignore = true),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "modifiedBy", ignore = true),
    })
    BaseEntity anyDtoToEntity(BaseDto dto);
}
