package com.tech.challenge.mapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ResponseMapper<D, R> {

    R toResponse(D model);

    List<R> toResponse(List<D> models);

}