package com.connectto.repositores;


import com.connectto.DTO.AirplaneInfoGetDto;
import com.connectto.DTO.TicketDto;
import com.connectto.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    @Query("SELECT new com.connectto.DTO.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a  " +
            "WHERE (?1 IS NULL OR a.cityDepartune LIKE %?1%)" +
            "AND (?2 IS NULL OR a.cityArrival LIKE %?2%)" +
            "AND (?3 IS NULL OR a.remarks = ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel = ?4)" +
            "AND (?5 IS NULL OR a.timeDepature = ?5)")
    List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival,
                                             String remarks, String timeArrivel, String timeDepature);

    @Query("SELECT new com.connectto.DTO.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a ")
    List<AirplaneInfoGetDto> getAll();

    Airplane getByFlightNo(String flightNo);

    @Query("SELECT new com.connectto.DTO.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a  where a.flightNo = ?1")
    AirplaneInfoGetDto getFlightNoUpdate(String flightNo);

    @Query("SELECT new com.connectto.DTO.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a WHERE a.flightNo = ?1 ")
    AirplaneInfoGetDto getByFlightNoSearch(String flightNo);


    @Query("SELECT new com.connectto.DTO.AirplaneInfoGetDto(u.flightNo,u.cityDepartune," +
            " u.cityArrival, u.timeDepature, u.timeArrivel, u.remarks)" +
            "FROM Airplane u WHERE u.id IN (SELECT l.airplane.id FROM Flight l WHERE l.id IN" +
            "(SELECT p.flight.id FROM Book p WHERE p.user.id IN " +
            "(SELECT m.id FROM User m WHERE m.email = ?1 ))) AND" +
            "(u.remarks = 'DELAYYED' OR u.remarks = 'CANCELLED')")
    List<AirplaneInfoGetDto> login(String email);

    @Query("SELECT new com.connectto.DTO.TicketDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks," +
            " p.price ,p.statusTicket,p.count ) " +
            "FROM Airplane a " +
            "LEFT JOIN Flight p on (a.id=p.airplane.id)" +
            "WHERE a.id IN " +
            "(SELECT i.airplane.id FROM Flight i)" +
            "AND (?1 IS NULL OR a.cityDepartune = ?1)" +
            "AND (?2 IS NULL OR a.cityArrival = ?2)" +
            "AND (?3 IS NULL OR a.timeDepature >= ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel <= ?4)")
    List<TicketDto> getAirplaneByFlightTicket(String cityDepartune, String cityArrival, String timeFrom, String timeTo);

    @Query("SELECT new com.connectto.DTO.TicketDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks," +
            " p.price ,p.statusTicket,p.count ) " +
            "FROM Airplane a " +
            "LEFT JOIN Flight p on (a.id=p.airplane.id)" +
            "WHERE a.id IN " +
            "(SELECT i.airplane.id FROM Flight i WHERE i.count >= 1)" +
            "AND (a.remarks = 'ON_TIME')" +
            "AND (?1 IS NULL OR a.cityDepartune = ?1)" +
            "AND (?2 IS NULL OR a.cityArrival = ?2)" +
            "AND (?3 IS NULL OR a.timeDepature >= ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel <= ?4)")
    List<TicketDto> getAirplaneByFlightTicketUser(String cityDepartune, String cityArrival, String timeFrom, String timeTo);
}
