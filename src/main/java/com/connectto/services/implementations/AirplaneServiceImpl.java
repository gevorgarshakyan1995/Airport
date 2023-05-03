package com.connectto.services.implementations;

import com.connectto.DTO.AirplaneSaveDtoReq;
import com.connectto.DTO.AirplaneInfoGetDto;
import com.connectto.Exception.NotFoundException;
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

        List<AirplaneInfoGetDto> list =airplaneRepository.findAllBy();
        if (cityArrival != null && !cityArrival.isEmpty()) {
            list.removeIf(flightInfoGetDto -> !cityArrival.equals(flightInfoGetDto.getCityArrival()));
        }
        if (cityDepartune != null && !cityDepartune.isEmpty()) {
            list.removeIf(flightInfoGetDto -> !cityDepartune.equals(flightInfoGetDto.getCityDepartune()));
        }
        if (timeArrivel != null && !timeArrivel.isEmpty()) {
            list.removeIf(flightInfoGetDto -> !((flightInfoGetDto.getTimeArrivel().compareTo(LocalTime.parse(timeArrivel))) == 0));
        }
        if (timeDepature != null && !timeDepature.isEmpty()) {
            list.removeIf(flightInfoGetDto -> !((flightInfoGetDto.getTimeDepature().compareTo(LocalTime.parse(timeDepature))) == 0));
        }

        if (remarks != null && !remarks.isEmpty()) {
            list.removeIf(flightInfoGetDto -> !(flightInfoGetDto.getRemarks() == Remarks.valueOf(remarks)));
        }
        return list;
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
    public List<AirplaneInfoGetDto> findAllBy() {
        return airplaneRepository.findAllBy();
    }

}
