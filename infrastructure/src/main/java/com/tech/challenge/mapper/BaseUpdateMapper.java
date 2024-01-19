package com.tech.challenge.mapper;

import org.mapstruct.MappingTarget;

public interface BaseUpdateMapper<D, E> {
    void update(@MappingTarget E entity, D model);
}
