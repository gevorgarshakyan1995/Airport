package com.connectto.services.implementations;

import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.Mapper.FlightMapper;
import com.connectto.enums.Remarks;
import com.connectto.repositores.FlightRepository;
import com.connectto.services.interfaces.LoginService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class LoginSeviceImpl implements LoginService {

    @Autowired
    private FlightRepository flightRepository;

    private final FlightMapper mapper  = Mappers.getMapper(FlightMapper.class);

    @Override
    public List<FlightInfoGetDto> login(Principal principal) {
        List<FlightInfoGetDto> list = mapper.toFlightDtos(flightRepository.findByBookUserEmail(principal.getName()));
        list.removeIf(flightInfoGetDto -> flightInfoGetDto.getRemarks() == Remarks.ON_TIME);
        return list;
    }

}
