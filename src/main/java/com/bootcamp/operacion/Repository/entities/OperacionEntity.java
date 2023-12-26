package com.bootcamp.operacion.Repository.entities;

import com.bootcamp.operacion.model.entity.Operacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "operacion")
public class OperacionEntity {
    @Id
    private String id;
    private String cuentaDestino;
    private BigDecimal monto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaHoraOperacion;
    private String descripcion;
    private String cuentaId;

    public OperacionEntity() {

    }
    public OperacionEntity toOperacionEntity(Operacion operacion) {
        OperacionEntity operacionEntity = OperacionEntity.builder().build();
        BeanUtils.copyProperties(operacion, operacionEntity);
        return operacionEntity;
    }
    public Operacion toOperacion() {
        Operacion operacion = Operacion.builder().build();
        BeanUtils.copyProperties( this, operacion);
        return operacion;
    }
}
