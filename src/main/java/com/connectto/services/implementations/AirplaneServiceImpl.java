package com.connectto.services.implementations;

import com.connectto.DTO.AirplaneDto;
import com.connectto.DTO.SearchAirplaneDto;
import com.connectto.Exception.NotFoundException;
import com.connectto.Mapper.AirplaneMapper;
import com.connectto.model.Airplane;
import com.connectto.model.User;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.AirplaneService;
import com.connectto.specification.AirplaneSpecifications;
import com.connectto.util.MailSender;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    private final AirplaneMapper mapper = Mappers.getMapper(AirplaneMapper.class);

    @Override
    public void save(AirplaneDto airplaneDto) {
        Airplane airplane = mapper.toAirplane(airplaneDto);
        airplaneRepository.save(airplane);

    }

    @Override
    public List<AirplaneDto> getAllAndSearch(SearchAirplaneDto airplaneSearchDto) {
        Specification<Airplane> specification = AirplaneSpecifications.getAllAndSearch(airplaneSearchDto.getCityDepartune(),
                airplaneSearchDto.getCityArrival(), airplaneSearchDto.getRemarks(), airplaneSearchDto.getTimeArrivel(),
                airplaneSearchDto.getTimeDepature());
        return mapper.toAirplaneDto(airplaneRepository.findAll(specification));
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
    public void Update(AirplaneDto airplaneDto) {
        Airplane airplane1 = airplaneRepository.getByFlightNo(airplaneDto.getFlightNo());
        airplane1.setRemarks(airplaneDto.getRemarks());
        airplane1.setTimeArrivel(airplaneDto.getTimeArrivel());
        airplane1.setTimeDepature(airplaneDto.getTimeDepature());
        airplane1.setFlightNo(airplaneDto.getFlightNo());
        airplaneRepository.save(airplane1);
        String subject = "Airplane company";
        String text = "Changed the flight of the plane   " + airplane1.toString();
        List<User> users = userRepository.findByBook_Flight_Id(airplane1.getId());
        for (User user : users) {
            mailSender.tokenSimpleMessage(user.getEmail(), subject, text);
        }
    }

}
