package com.connectto.services.interfaces;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.enums.Remarks;
import com.connectto.model.Airplane;


import java.time.LocalTime;
import java.util.List;

public interface AirplaneService {


    void save(AirplaneSaveDtoReq airplaneSaveDtoReq);

    List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival,
                                             String remarks, String timeArrivel,
                                             String timeDepature);

    List<AirplaneInfoGetDto> getAll();

    Airplane flightNo (String flightNo )throws NotFoundException;

    void update (String flightNo, String remarks) throws NotFoundException;

    AirplaneInfoGetDto getByFlightNoSearch (String flightNo)throws NotFoundException;
}
