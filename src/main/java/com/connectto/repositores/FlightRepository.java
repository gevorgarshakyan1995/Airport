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

    Flight getByStatusTicketAndAirplane_FlightNo(StatusTicket StatusTicket, String Airplane_FlightNo);

    @Query("SELECT new com.connectto.DTO.FlightInfoGetDto(u.flightNo,u.cityDepartune," +
            "u.cityArrival, u.timeDepature, u.timeArrivel, u.remarks, p.price, p.count, p.statusTicket)" +
            "FROM Flight p  " +
            "LEFT JOIN Airplane u on (p.airplane.id=u.id)" +
            "LEFT JOIN Book b on (p.id=b.flight.id)" +
            "LEFT JOIN User k on (b.user.id = k.id)" +
            "WHERE (k.email = ?1) AND" +
            "(u.remarks = 'DELAYYED' OR u.remarks = 'CANCELLED')")
    List<FlightInfoGetDto> flightByDelayedOrCancelledForUser(String email);

    @Query("SELECT new com.connectto.DTO.FlightInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks," +
            " p.price ,p.count, p.statusTicket ) " +
            "FROM Flight p " +
            "LEFT JOIN Airplane a on (p.airplane.id=a.id)" +
            "WHERE  (?1 IS NULL OR a.cityDepartune = ?1)" +
            "AND (?2 IS NULL OR a.cityArrival = ?2)" +
            "AND (?3 IS NULL OR a.timeDepature >= ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel <= ?4)")
    List<FlightInfoGetDto> getFlightAndfilters(String cityDepartune, String cityArrival, String timeFrom, String timeTo);

    @Query("SELECT new com.connectto.DTO.FlightInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks," +
            " p.price ,p.count, p.statusTicket ) " +
            "FROM Flight p " +
            "LEFT JOIN Airplane a on (p.airplane.id =a.id)" +
            "WHERE (p.count >= 1)" +
            "AND (a.remarks = 'ON_TIME')" +
            "AND (?1 IS NULL OR a.cityDepartune = ?1)" +
            "AND (?2 IS NULL OR a.cityArrival = ?2)" +
            "AND (?3 IS NULL OR a.timeDepature >= ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel <= ?4)")
    List<FlightInfoGetDto> getFlightAndfiltersUser(String cityDepartune, String cityArrival, String timeFrom, String timeTo);
}
