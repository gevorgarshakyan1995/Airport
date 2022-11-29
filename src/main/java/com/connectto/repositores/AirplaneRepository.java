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
            "AND (?2 IS NULL OR a.cityArrival LIKE %?2%)")
    List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival);

}
