package com.tech.challenge.mapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface BaseDomainMapper<D, E> {

    D toDomain(E entity);

    List<D> toDomain(List<E> entity);

    Optional<D> toDomain(Optional<E> entity);

    Mono<D> toDomain(Mono<E> entity);

    Flux<D> toDomain(Flux<E> entity);


}