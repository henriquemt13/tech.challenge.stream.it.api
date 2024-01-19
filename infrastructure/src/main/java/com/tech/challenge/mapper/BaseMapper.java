package com.tech.challenge.mapper;

public interface BaseMapper<D, E>
        extends BaseUpdateMapper<D, E>, BaseDomainMapper<D, E>, BaseEntityMapper<D, E> {}