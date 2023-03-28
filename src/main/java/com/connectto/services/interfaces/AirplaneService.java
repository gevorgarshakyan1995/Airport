package com.connectto.services.interfaces;

import com.connectto.DTO.AirplaneSaveDtoReq;
import com.connectto.DTO.AirplaneInfoGetDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.model.Airplane;


import java.util.List;

public interface AirplaneService {


    void save(AirplaneSaveDtoReq airplaneSaveDtoReq);

    List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival,
                                             String remarks, String timeArrivel,
                                             String timeDepature);


    Airplane flightNo (String flightNo )throws NotFoundException;

    void update (String flightNo, String remarks) throws NotFoundException;

    List<AirplaneInfoGetDto> findAllBy();

}
