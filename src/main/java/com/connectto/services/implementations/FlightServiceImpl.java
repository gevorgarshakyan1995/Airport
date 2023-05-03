package com.connectto.services.implementations;

import com.connectto.DTO.AirplaneSaveDtoReq;
import com.connectto.DTO.FlightDtoReq;
import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.enums.Remarks;
import com.connectto.enums.StatusTicket;
import com.connectto.model.*;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.repositores.BookRepository;
import com.connectto.repositores.FlightRepository;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.FlightService;
import com.connectto.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public void save(FlightDtoReq flightDtoReq) {
        Airplane airplane = airplaneRepository.getByFlightNo(flightDtoReq.getFlightNo());
        Flight flight = new Flight();
        flight.setCount(flightDtoReq.getCount());
        flight.setAirplane(airplane);
        flight.setPrice(flight.getPrice());
        flight.setStatusTicket(flight.getStatusTicket());
        flightRepository.save(flight);
    }

    @Override
    public ModelAndView getAirplaneByFlightTicket(String cityDepartune, String cityArrival, String timeFrom,
                                                  String timeTo, Principal principal) {
        boolean admin = false;
        User user = userRepository.getByEmail(principal.getName());
        for (Authority authority : user.getAuthoriti()) {
            if (Objects.equals(authority.getName(), "ROLE_ADMIN")) {
                admin = true;
            }
        }
        if (admin) {
            ModelAndView mav = new ModelAndView("list-airplanes");
            List<FlightInfoGetDto> list = flightRepository.getFlightAndfilters(cityDepartune, cityArrival,
                    timeFrom, timeTo);
            mav.addObject("airplanes", list);
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("list-airplanes-user");
            List<FlightInfoGetDto> list = flightRepository.getFlightAndfiltersUser(cityDepartune, cityArrival,
                    timeFrom, timeTo);
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
    public void Update(AirplaneSaveDtoReq airplane) {
        Airplane airplane1 = airplaneRepository.getByFlightNo(airplane.getFlightNo());
        airplane1.setRemarks(Remarks.valueOf(airplane.getRemarks()));
        airplane1.setTimeArrivel(airplane.getTimeArrivel());
        airplane1.setTimeDepature(airplane.getTimeDepature());
        airplane1.setFlightNo(airplane.getFlightNo());
        airplaneRepository.save(airplane1);
        String subject = "Airplane company";
        String text = "Changed the flight of the plane   " + airplane1.toString();
        List<User> users = userRepository.findByBook_Flight_Id(airplane1.getId());
        for (User user : users) {
            mailSender.tokenSimpleMessage(user.getEmail(), subject, text);
        }
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
