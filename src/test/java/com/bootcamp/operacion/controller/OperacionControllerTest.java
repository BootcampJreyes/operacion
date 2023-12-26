package com.bootcamp.operacion.controller;

import com.bootcamp.operacion.businees.OperacionService;
import com.bootcamp.operacion.infrastructure.controller.OperacionController;
import com.bootcamp.operacion.model.entity.Operacion;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(OperacionController.class)
class OperacionControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private OperacionService operacionService;

    @Test
    void findAll(){
        when(operacionService.findAll()).thenReturn(Flux.just(getOperacion()));
        webTestClient.get()
                .uri("/operacion/findAll")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Operacion.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void save(){
        when(operacionService.create(getOperacion())).thenReturn(Mono.just(getOperacion()));
        webTestClient.post()
                .uri("/operacion/save")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getOperacion())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Operacion.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void findAllBy(){
        when(operacionService.findAllBy("1")).thenReturn(Mono.just(getOperacion()));
        webTestClient.get()
                .uri("/operacion/findAllBy?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Operacion.class)
                .hasSize(1)
                .contains();
    }

    @Test
    void update(){
        when(operacionService.update(getOperacion())).thenReturn(Mono.just(getOperacion()));
        webTestClient.put()
                .uri("/operacion/update")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(getOperacion())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Operacion.class)
                .hasSize(0)
                .contains();
    }

    @Test
    void deleteById() {
        when(operacionService.deleteById("1")).thenReturn(Mono.empty());
        webTestClient.delete()
                .uri("/operacion/delete?id=1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }

    public Operacion getOperacion(){
        return new Operacion("156485","15555472345687",new BigDecimal(2220.00),new Date(1994,03,17)
                ,"pago","94437894712865");
    }
}
