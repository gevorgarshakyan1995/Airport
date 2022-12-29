package com.connectto.repositores;


import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    @Query("SELECT new com.connectto.DTO.Response.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a  " +
            "WHERE (?1 IS NULL OR a.cityDepartune LIKE %?1%)" +
            "AND (?2 IS NULL OR a.cityArrival LIKE %?2%)" +
            "AND (?3 IS NULL OR a.remarks = ?3)" +
            "AND (?4 IS NULL OR a.timeArrivel = ?4)" +
            "AND (?5 IS NULL OR a.timeDepature = ?5)")
    List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival,
                                             String remarks, String timeArrivel, String timeDepature);

    @Query("SELECT new com.connectto.DTO.Response.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a ")
    List<AirplaneInfoGetDto> getAll();

    Airplane getByFlightNo(String flightNo);

    @Query("SELECT new com.connectto.DTO.Response.AirplaneInfoGetDto(a.flightNo, " +
            "a.cityDepartune, a.cityArrival, a.timeDepature, a.timeArrivel, a.remarks) " +
            "FROM Airplane a WHERE a.flightNo = ?1 ")
    AirplaneInfoGetDto getByFlightNoSearch (String flightNo);


    @Query(nativeQuery = true, value = "SELECT * FROM airplane WHERE id IN" +
            "(SELECT airplane_id FROM flight WHERE id IN " +
            "(SELECT flight_id FROM book_flight WHERE book_id IN " +
            "(SELECT id FROM BOOK  WHERE user_id IN " +
            "(SELECT id FROM USER WHERE email = ?1 )))) AND" +
            "(remarks = 'DELAYYED' OR remarks = 'CANCELLED')")
    List<Airplane> go(String email) ;


}
