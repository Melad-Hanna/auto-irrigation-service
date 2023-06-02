package com.banquemisr.autoirrigationservice.service;

import com.banquemisr.autoirrigationservice.constant.MessagesConstants;
import com.banquemisr.autoirrigationservice.dao.BaseDao;
import com.banquemisr.autoirrigationservice.dto.BaseDto;
import com.banquemisr.autoirrigationservice.model.BaseEntity;
import com.banquemisr.autoirrigationservice.transformer.BaseTransformer;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public interface BaseService<Entity extends BaseEntity, Dto extends BaseDto, Transformer extends BaseTransformer, Dao extends BaseDao> {

    Transformer getTransformer();

    Dao getDao();

    default Entity doBeforeCreateEntity(Entity entity, Dto dto) {
        return entity;
    }

    default List<Entity> doBeforeCreateEntity(List<Entity> entities, List<Dto> dtos) {
        return entities;
    }

    /**
     * do before update the entity record in DB
     *
     * @param dto
     * @return
     */
    default Entity doBeforeUpdateEntity(Entity entity, Dto dto) {
        return entity;
    }

    default Entity doCreate(Dto dto) {
        Entity dtoToEntity = (Entity) getTransformer().transformDTOToEntity(dto);
        Entity toBeSavedEntity = doBeforeCreateEntity(dtoToEntity, dto);
        Entity savedEntity = (Entity) getDao().create(toBeSavedEntity);
        return savedEntity;
    }

    default Dto create(Dto dto) {
        Entity savedDEntity = doCreate(dto);
        return (Dto) getTransformer().transformEntityToDTO(savedDEntity);
    }

    default Entity doUpdate(Dto dto, Long id) {
        Optional<Entity> entity = getDao().findById(id);
        if (entity.isEmpty())
            throw new EntityNotFoundException(MessagesConstants.ITEM_NOT_FOUND);
        Entity dtoToEntity = entity.get();
        getTransformer().updateEntity(dto, dtoToEntity);
        Entity toBeSavedEntity = doBeforeUpdateEntity(dtoToEntity, dto);
        Entity savedDEntity = (Entity) getDao().update(toBeSavedEntity);
        return savedDEntity;
    }

    default Dto update(Dto dto, Long id) {
        Entity savedDEntity = doUpdate(dto, id);
        return (Dto) getTransformer().transformEntityToDTO(savedDEntity);
    }

    default Dto findById(Long id) {
        return (Dto) getTransformer().transformEntityToDTO(findEntityById(id));
    }

    default Entity findEntityById(Long id) {
        Optional<Entity> optionalEntity = getDao().findById(id);
        if (optionalEntity.isEmpty())
            throw new EntityNotFoundException(MessagesConstants.ITEM_NOT_FOUND);
        return optionalEntity.get();
    }

    default List<Dto> findAll() {
        return getTransformer().transformEntityToDTO(getDao().findAll());
    }

    default List<Dto> findAll(boolean markedAsDeleted) {
        return getTransformer().transformEntityToDTO(getDao().findAll(markedAsDeleted));
    }
}