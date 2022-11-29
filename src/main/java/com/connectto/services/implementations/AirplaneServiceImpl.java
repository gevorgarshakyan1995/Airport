package com.connectto.services.implementations;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.enums.Remarks;
import com.connectto.model.Airplane;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.services.interfaces.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public void save(AirplaneSaveDtoReq airplaneSaveDtoReq) {
        Airplane airplane = new Airplane();
        airplane.setRemarks(Remarks.valueOf(airplaneSaveDtoReq.getRemarks()));
        airplane.setCityArrival(airplaneSaveDtoReq.getCityArrival());
        airplane.setCityDepartune(airplaneSaveDtoReq.getCityDepartune());
        airplane.setFlightNo(airplaneSaveDtoReq.getFlightNo());
        airplane.setTimeArrivel(airplaneSaveDtoReq.getTimeArrivel());
        airplane.setTimeDepature(airplaneSaveDtoReq.getTimeDepature());

        airplaneRepository.save(airplane);

    }

    @Override
    public List<AirplaneInfoGetDto> getAllAndSearch(String cityDepartune, String cityArrival,
                                                    String remarks, String timeArrivel,
                                                    String timeDepature) {

        return airplaneRepository.getAllAndSearch(cityDepartune, cityArrival, remarks
                , timeArrivel, timeDepature);
    }


}
