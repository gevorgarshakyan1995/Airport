package com.connectto.services.interfaces;

import com.connectto.DTO.AirplaneDto;
import com.connectto.DTO.SearchAirplaneDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.model.Airplane;


import java.util.List;

public interface AirplaneService {


    void save(AirplaneDto airplaneDto);

    List<AirplaneDto> getAllAndSearch(SearchAirplaneDto airplaneSearchDto);

    Airplane flightNo (String flightNo )throws NotFoundException;

    void Update(AirplaneDto airplane);


}
