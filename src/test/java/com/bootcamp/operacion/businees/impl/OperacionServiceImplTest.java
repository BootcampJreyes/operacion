package com.bootcamp.operacion.businees.impl;

import com.bootcamp.operacion.Repository.OperacionRepository;
import com.bootcamp.operacion.Repository.entities.OperacionEntity;
import com.bootcamp.operacion.model.entity.Operacion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperacionServiceImplTest {
    @Mock
    private OperacionRepository operacionRepository;
    @InjectMocks
    private OperacionServiceImpl operacionServiceImpl;


    @Test
    void findAll() {
        when(operacionRepository.findAll()).thenReturn(Flux.just(getOperacionEntity()));
        when(operacionServiceImpl.findAll()).thenReturn(Flux.just(getOperacion()));

        Flux<Operacion> resultado = operacionServiceImpl.findAll();
        StepVerifier.create(resultado) // Verifica que haya dos elementos en el flujo
                .expectNext(getOperacion())
                .expectComplete()
                .verify();
    }

    @Test
    void save() {
        when(operacionRepository.save(getOperacionEntity())).thenReturn(Mono.just(getOperacionEntity()));
        when(operacionServiceImpl.create(getOperacion())).thenReturn(Mono.just(getOperacion()));

        Mono<Operacion> resultado = operacionServiceImpl.create(getOperacion());

        StepVerifier.create(resultado)
                .expectNext(getOperacion())
                .expectComplete()
                .verify();
    }

    @Test
    void findAllBy() {
        when(operacionRepository.findById(anyString())).thenReturn(Mono.just(getOperacionEntity()));
        when(operacionServiceImpl.findAllBy(anyString())).thenReturn(Mono.just(getOperacion()));

        Mono<Operacion> resultado = operacionServiceImpl.findAllBy("1");

        StepVerifier.create(resultado)
                .expectNext(getOperacion())
                .expectComplete()
                .verify();
    }

    @Test
    void update() {
        when(operacionRepository.save(any())).thenReturn(Mono.just(getOperacionEntity()));
        when(operacionServiceImpl.update(any())).thenReturn(Mono.just(getOperacion()));

        Mono<Operacion> resultado = operacionServiceImpl.update(getOperacion());

        StepVerifier.create(resultado)
                .expectNext(getOperacion())
                .expectComplete()
                .verify();
    }

    @Test
    void deleteById() {
        when(operacionRepository.deleteById(anyString())).thenReturn(Mono.empty());
        when(operacionServiceImpl.deleteById(anyString())).thenReturn(Mono.empty());

        Mono<Void> resultado = operacionServiceImpl.deleteById("1");

        StepVerifier.create(resultado)
                .expectComplete()
                .verify();
    }

    public OperacionEntity getOperacionEntity(){
        return new OperacionEntity("156485","15555472345687",new BigDecimal(2220.00),new Date(1994,03,17)
                ,"pago","94437894712865");
    }
    public Operacion getOperacion(){
        return new Operacion("156485","15555472345687",new BigDecimal(2220.00),new Date(1994,03,17)
                ,"pago","94437894712865");
    }
}
