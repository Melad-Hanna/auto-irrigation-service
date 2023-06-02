package com.banquemisr.autoirrigationservice.dao;

import com.banquemisr.autoirrigationservice.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface BaseDao<Entity extends BaseEntity, Repo extends JpaRepository<Entity, Long>> {
    Repo getRepository();

    default Entity create(Entity entity) {
        return getRepository().save(entity);
    }

    default Entity update(Entity entity) {
        return getRepository().save(entity);
    }

    default Optional<Entity> findById(Long id) {
        return getRepository().findById(id);
    }

    default List<Entity> findAll() {
        return getRepository().findAll();
    }

    default List<Entity> findAll(Boolean markedAsDeleted) {
        return new LinkedList<>();
    }

    default List<Entity> findAllById(Iterable<Long> iterable) {
        return getRepository().findAllById(iterable);
    }
}
