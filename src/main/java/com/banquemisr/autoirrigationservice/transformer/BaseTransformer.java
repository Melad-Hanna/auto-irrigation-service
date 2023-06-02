package com.banquemisr.autoirrigationservice.transformer;

import com.banquemisr.autoirrigationservice.dto.BaseDto;
import com.banquemisr.autoirrigationservice.model.BaseEntity;
import com.banquemisr.autoirrigationservice.transformer.mapper.BaseMapper;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseTransformer<Entity extends BaseEntity, Dto extends BaseDto, Mapper extends BaseMapper> {

    Mapper getMapper();

    default Dto transformEntityToDTO(Entity entity) {
        return (Dto) getMapper().entityToDto(entity);
    }

    default List<Dto> transformEntityToDTO(List<Entity> entities) {
        return entities.stream().map(this::transformEntityToDTO).collect(Collectors.toList());
    }

    default Entity transformDTOToEntity(Dto dto) {
        return (Entity) getMapper().dtoToEntity(dto);
    }

    default List<Entity> transformDTOToEntity(List<Dto> dtos) {
        return dtos.stream().map(this::transformDTOToEntity).collect(Collectors.toList());
    }

    default void updateEntity(Dto dto, Entity entity) {
        getMapper().updateEntity(dto, entity);
    }
}
