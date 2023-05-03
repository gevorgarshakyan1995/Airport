package com.connectto.repositores;


import com.connectto.DTO.AirplaneInfoGetDto;
import com.connectto.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    Airplane getByFlightNo(String flightNo);

    List<AirplaneInfoGetDto> findAllBy();


}
