package com.connectto.services.implementations;

import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.model.Airplane;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginSeviceImpl implements LoginService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Override
    public List<AirplaneInfoGetDto> login(Principal principal) {
        List<AirplaneInfoGetDto> list = new ArrayList<>();
        List<Airplane> list1 = airplaneRepository.go(principal.getName());
        for (Airplane airplane : list1) {
            AirplaneInfoGetDto airplaneInfoGetDto = new AirplaneInfoGetDto(airplane.getFlightNo(),
                    airplane.getCityDepartune(), airplane.getCityArrival(), airplane.getTimeDepature(),
                    airplane.getTimeArrivel(), airplane.getRemarks());
            list.add(airplaneInfoGetDto);
        }
        return list;
    }
}
