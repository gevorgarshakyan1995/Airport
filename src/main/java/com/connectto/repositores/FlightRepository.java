package com.connectto.repositores;


import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.enums.StatusTicket;
import com.connectto.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight getByAirplane_IdAndStatusTicket(Long airplane_Id, StatusTicket StatusTicket);

    @Query("SELECT new com.connectto.DTO.FlightInfoGetDto(u.flightNo,u.cityDepartune," +
            "u.cityArrival, u.timeDepature, u.timeArrivel, u.remarks, p.price, p.count, p.statusTicket)" +
            "FROM Airplane u " +
            "LEFT JOIN Flight p on (u.id=p.airplane.id)" +
            "WHERE u.id IN (SELECT l.airplane.id FROM Flight l WHERE l.id IN" +
            "(SELECT p.flight.id FROM Book p WHERE p.user.id IN " +
            "(SELECT m.id FROM User m WHERE m.email = ?1 ))) AND" +
            "(u.remarks = 'DELAYYED' OR u.remarks = 'CANCELLED')")
    List<FlightInfoGetDto> flidgtbyDelayedOrCancelled(String email);

    @Query("SELECT new com.connectto.DTO.FlightInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks," +
            " p.price ,p.count, p.statusTicket ) " +
            "FROM Airplane a " +
            "LEFT JOIN Flight p on (a.id=p.airplane.id)" +
            "WHERE a.id IN " +
            "(SELECT i.airplane.id FROM Flight i)" +
            "AND (?1 IS NULL OR a.cityDepartune = ?1)" +
            "AND (?2 IS NULL OR a.cityArrival = ?2)" +
            "AND (?3 IS NULL OR a.timeDepature >= ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel <= ?4)")
    List<FlightInfoGetDto> getFlightAndfilters (String cityDepartune, String cityArrival, String timeFrom, String timeTo);

    @Query("SELECT new com.connectto.DTO.FlightInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks," +
            " p.price ,p.count, p.statusTicket ) " +
            "FROM Airplane a " +
            "LEFT JOIN Flight p on (a.id=p.airplane.id)" +
            "WHERE a.id IN " +
            "(SELECT i.airplane.id FROM Flight i WHERE i.count >= 1)" +
            "AND (a.remarks = 'ON_TIME')" +
            "AND (?1 IS NULL OR a.cityDepartune = ?1)" +
            "AND (?2 IS NULL OR a.cityArrival = ?2)" +
            "AND (?3 IS NULL OR a.timeDepature >= ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel <= ?4)")
    List<FlightInfoGetDto> getFlightAndfiltersUser (String cityDepartune, String cityArrival, String timeFrom, String timeTo);
}
