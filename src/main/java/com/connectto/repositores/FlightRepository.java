package com.connectto.repositores;


import com.connectto.enums.StatusTicket;
import com.connectto.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    Flight getByStatusTicketAndAirplane_FlightNo(StatusTicket StatusTicket, String Airplane_FlightNo);


    List<Flight> findByAirplaneIsNotNull();

}
