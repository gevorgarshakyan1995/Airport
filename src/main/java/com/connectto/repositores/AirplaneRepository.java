package com.connectto.repositores;


import com.connectto.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long>, JpaSpecificationExecutor<Airplane> {

    Airplane getByFlightNo(String flightNo);

}
