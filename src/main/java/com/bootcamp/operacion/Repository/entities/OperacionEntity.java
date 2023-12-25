package com.bootcamp.operacion.Repository.entities;

import com.bootcamp.operacion.model.entity.Operacion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "operacion")
public class OperacionEntity {
    @Id
    private String id;
    private String dni;
    private String nombre;
    private String apellido;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String fechaNacimiento;
    private String celular;
    private String email;
    private String ciudad;

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
