package com.bootcamp.operacion.infrastructure.controller;

import com.bootcamp.operacion.businees.OperacionService;
import com.bootcamp.operacion.model.entity.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(OperacionController.OPERACION)
public class OperacionController {
    public static final String OPERACION = "/operacion";
    public static final String FINDALL = "/findAll";
    public static final String SAVE = "/save";
    public static final String FINDALLBY = "/findAllBy";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    @Autowired
    private OperacionService operacionService;

    @RequestMapping(FINDALL)
    private Flux<Operacion> findAll() {
        return operacionService.findAll();
    }

    @PostMapping(SAVE)
    private Mono<Operacion> create(@RequestBody Operacion operacion) {
        return operacionService.create(operacion);
    }

    @GetMapping(FINDALLBY)
    private Mono<Operacion> findAllBy(@RequestParam("id") String id) throws Exception{
        return operacionService.findAllBy(id);
    }

    @PutMapping(UPDATE)
    private Mono<Operacion> update(@RequestBody Operacion operacion){
        return operacionService.update(operacion);
    }

    @DeleteMapping(DELETE)
    private Mono<Void> deleteById(@RequestParam("id") String id){
        return operacionService.deleteById(id);
    }
}
