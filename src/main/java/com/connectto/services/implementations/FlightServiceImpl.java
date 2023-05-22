package com.connectto.services.implementations;

import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.DTO.FlightSaveDto;
import com.connectto.DTO.SearchFligtDto;
import com.connectto.Mapper.FlightMapper;
import com.connectto.enums.StatusTicket;
import com.connectto.model.*;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.repositores.BookRepository;
import com.connectto.repositores.FlightRepository;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.FlightService;
import com.connectto.specification.FlightSpecifications;
import com.connectto.util.MailSender;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Objects;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MailSender mailSender;

    private final FlightMapper mapper = Mappers.getMapper(FlightMapper.class);

    @Override
    public void save(FlightSaveDto flightSaveDto) {
        Airplane airplane = airplaneRepository.getByFlightNo(flightSaveDto.getAirplane().getFlightNo());
        Flight flight = mapper.toFlight(flightSaveDto);
        flight.setAirplane(airplane);
        flightRepository.save(flight);
    }

    @Override
    public ModelAndView getAirplaneByFlightTicket(SearchFligtDto fligtDto, Principal principal) {
        boolean admin = false;
        User user = userRepository.getByEmail(principal.getName());
        for (Authority authority : user.getAuthoriti()) {
            if (Objects.equals(authority.getName(), "ROLE_ADMIN")) {
                admin = true;
            }
        }
        if (admin) {
            Specification<Flight> specification = FlightSpecifications.getAllAndSearchForAdmin(fligtDto.getCityDepartune(),
                    fligtDto.getCityArrival(), fligtDto.getTimeFrom(), fligtDto.getTimeTo());
            List<FlightInfoGetDto> list = mapper.toFlightDtos(flightRepository.findAll(specification));
            ModelAndView mav = new ModelAndView("list-airplanes");
            mav.addObject("airplanes", list);
            return mav;
        } else {
            Specification<Flight> specification = FlightSpecifications.getAllAndSearchForUsers(fligtDto.getCityDepartune(),
                    fligtDto.getCityArrival(), fligtDto.getTimeFrom(), fligtDto.getTimeTo());
            List<FlightInfoGetDto> list = mapper.toFlightDtos(flightRepository.findAll(specification));
            ModelAndView mav = new ModelAndView("list-airplanes-user");
            mav.addObject("airplanes", list);
            return mav;
        }
    }

    @Override
    @Transactional
    public void bookTichet(String flightNo, String statusTicket, Principal principal) {
        User user = userRepository.getByEmail(principal.getName());
        Flight flight = flightRepository.getByStatusTicketAndAirplane_FlightNo(StatusTicket.valueOf(statusTicket),
                flightNo);
        Book book = new Book();
        book.setFlight(flight);
        book.setUser(user);
        if (flight.getCount() > 0) {
            bookRepository.save(book);
            int i = flight.getCount() - 1;
            flight.setCount(i);
            flightRepository.save(flight);
        }
    }

    @Override
    public ModelAndView addUpdateForm(String flightNo) {
        ModelAndView mav = new ModelAndView("airplane-form");
        Airplane airplane = airplaneRepository.getByFlightNo(flightNo);
        mav.addObject("airplane", airplane);
        return mav;
    }


    @Override
    public void delete(String flightNo, String statusTicket) {
        Flight flight = flightRepository.getByStatusTicketAndAirplane_FlightNo(StatusTicket.valueOf(statusTicket),
                flightNo);
        List<User> users = userRepository.findByBook_Flight_Id(flight.getId());
        flightRepository.deleteById(flight.getId());
        String subject = "Airplane company";
        String text = "Delete the flight of the plane " + flightNo + " " + statusTicket;
        for (User user : users) {
            mailSender.tokenSimpleMessage(user.getEmail(), subject, text);
        }
    }
}
