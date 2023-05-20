package com.connectto.services.implementations;

import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.Mapper.FlightMapper;
import com.connectto.model.Flight;
import com.connectto.repositores.FlightRepository;
import com.connectto.services.interfaces.LoginService;
import com.connectto.specification.FlightSpecifications;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
        Specification<Flight> specification = FlightSpecifications.flightByDelayedOrCancelledForUser(principal.getName());
        return mapper.toFlightDtos(flightRepository.findAll(specification));
    }

}
