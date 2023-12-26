package com.bootcamp.operacion.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Operacion implements Serializable {
    @Id
    private String id;
    private String cuentaDestino;
    private BigDecimal monto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaHoraOperacion;
    private String descripcion;
    private String cuentaId;

}
