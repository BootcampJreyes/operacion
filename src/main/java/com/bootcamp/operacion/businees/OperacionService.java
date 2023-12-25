package com.bootcamp.operacion.businees;

import com.bootcamp.operacion.model.entity.Operacion;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OperacionService {
    Flux<Operacion> findAll();

    Mono<Operacion> create(Operacion Operacion);

    Mono<Operacion> findAllBy(String id);
    Mono<Operacion> update(Operacion Operacion);
    Mono<Void> deleteById(String id);

}
