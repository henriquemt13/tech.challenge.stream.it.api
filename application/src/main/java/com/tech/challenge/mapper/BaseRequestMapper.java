package com.tech.challenge.mapper;

public interface BaseRequestMapper<D, U, C> extends UpdateRequestMapper<D, U>, CreateRequestMapper<D, C> {
}