package com.tech.challenge.mapper;

public interface UpdateRequestMapper<D, U> {
    D updateRequestToDomain(U updateDto);

    U domainToUpdateRequest(D model);
}
