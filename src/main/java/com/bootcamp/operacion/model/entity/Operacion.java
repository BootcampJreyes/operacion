package com.bootcamp.operacion.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Operacion {
    @Id
    private String id;
    private String cuentaId;
    private String cuentaDestino;
    private String monto;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaHoraOperacion;
    private String descripcion;

}
