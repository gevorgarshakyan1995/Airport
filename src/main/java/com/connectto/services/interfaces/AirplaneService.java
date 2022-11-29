package com.connectto.services.interfaces;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.enums.Remarks;


import java.time.LocalTime;
import java.util.List;

public interface AirplaneService {

    void save(AirplaneSaveDtoReq airplaneSaveDtoReq);

    List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival,
                                             String remarks, String timeArrivel,
                                             String timeDepature);
}
