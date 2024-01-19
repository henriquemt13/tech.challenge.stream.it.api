package com.tech.challenge.mapper;

public interface CreateRequestMapper<D, C> {
    D createRequestToDomain(C addDto);
}