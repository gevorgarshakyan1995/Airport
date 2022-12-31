package com.connectto.repositores;


import com.connectto.enums.StatusTicket;
import com.connectto.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight getByAirplane_IdAndStatusTicket (Long airplane_Id, StatusTicket StatusTicket);
}
