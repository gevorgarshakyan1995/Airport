package com.connectto.services.implementations;

import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.repositores.FlightRepository;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class LoginSeviceImpl implements LoginService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightInfoGetDto> login(Principal principal) {
        return flightRepository.flidgtbyDelayedOrCancelledWithUser(principal.getName());
    }

}
