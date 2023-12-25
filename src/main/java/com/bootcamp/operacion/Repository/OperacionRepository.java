package com.bootcamp.operacion.Repository;

import com.bootcamp.operacion.Repository.entities.OperacionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionRepository extends ReactiveMongoRepository<OperacionEntity, String> {

}
