package com.connectto.services.interfaces;

import com.connectto.DTO.Response.AirplaneInfoGetDto;

import java.security.Principal;
import java.util.List;

public interface LoginService {

    List<AirplaneInfoGetDto> login (Principal principal);
}
