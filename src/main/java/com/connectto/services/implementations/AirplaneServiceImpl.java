package com.connectto.services.implementations;

import com.connectto.DTO.Request.AirplaneSaveDtoReq;
import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.enums.Remarks;
import com.connectto.model.Airplane;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.services.interfaces.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<AirplaneInfoGetDto> getAll() {
        return airplaneRepository.getAll();
    }

    @Override
    public Airplane flightNo(String flightNo) throws NotFoundException {
        Airplane airplane = airplaneRepository.getByFlightNo(flightNo);
        if (airplane == null) {
            throw new NotFoundException("Airplane not found");
        }
        return airplane;
    }

    @Override
    public void update(String flightNo, String remarks) throws NotFoundException {
        Airplane airplane = flightNo(flightNo);
        airplane.setRemarks(Remarks.valueOf(remarks));
        airplaneRepository.save(airplane);
    }

    @Override
    public AirplaneInfoGetDto getByFlightNoSearch(String flightNo) throws NotFoundException {
        AirplaneInfoGetDto airplaneInfoGetDto = airplaneRepository.getByFlightNoSearch(flightNo);
        if (airplaneInfoGetDto == null) {
            throw new NotFoundException("not found");
        }
        return airplaneInfoGetDto;
    }
}
