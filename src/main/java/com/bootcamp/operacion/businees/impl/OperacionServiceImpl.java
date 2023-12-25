package com.bootcamp.operacion.businees.impl;

import com.bootcamp.operacion.Repository.OperacionRepository;
import com.bootcamp.operacion.Repository.entities.OperacionEntity;
import com.bootcamp.operacion.businees.OperacionService;
import com.bootcamp.operacion.model.entity.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OperacionServiceImpl implements OperacionService {
    @Autowired
    private OperacionRepository OperacionRepository;

    @Override
    public Flux<Operacion> findAll() {
        return this.OperacionRepository
                .findAll()
                .map(OperacionEntity::toOperacion);
    }

    @Override
    public Mono<Operacion> create(Operacion operacion) {
        return OperacionRepository.save(new OperacionEntity().toOperacionEntity(operacion))
                .map(OperacionEntity::toOperacion);
    }

    @Override
    public Mono<Operacion> findAllBy(String id){
        return OperacionRepository.findById(id)
                .map(OperacionEntity::toOperacion);
    }
    @Override
    public Mono<Operacion> update(Operacion cuenta){
        return OperacionRepository.save(new OperacionEntity().toOperacionEntity(cuenta))
                .map(OperacionEntity::toOperacion);
    }
    @Override
    public Mono<Void> deleteById(String id){
        return OperacionRepository.deleteById(id);
    }
}
