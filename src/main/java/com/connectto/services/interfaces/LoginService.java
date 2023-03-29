package com.connectto.services.interfaces;

import com.connectto.DTO.FlightInfoGetDto;

import java.security.Principal;
import java.util.List;

public interface LoginService {

    List<FlightInfoGetDto> login(Principal principal);

}
