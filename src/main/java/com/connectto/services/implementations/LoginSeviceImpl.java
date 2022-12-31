package com.connectto.services.implementations;

import com.connectto.DTO.Response.AirplaneInfoGetDto;
import com.connectto.DTO.Response.TicketDto;
import com.connectto.enums.StatusTicket;
import com.connectto.model.Airplane;
import com.connectto.model.Book;
import com.connectto.model.Flight;
import com.connectto.model.User;
import com.connectto.repositores.AirplaneRepository;
import com.connectto.repositores.BookRepository;
import com.connectto.repositores.FlightRepository;
import com.connectto.repositores.UserRepository;
import com.connectto.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Service
public class LoginSeviceImpl implements LoginService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<AirplaneInfoGetDto> login(Principal principal) {
        return airplaneRepository.login(principal.getName());
    }

    @Override
    public ModelAndView getAirplaneByFlightTicket(String cityDepartune, String cityArrival, String timeFrom, String timeTo) {
        ModelAndView mav = new ModelAndView("list-airplanes");
        List<TicketDto> list = airplaneRepository.getAirplaneByFlightTicket(cityDepartune, cityArrival, timeFrom, timeTo);
        mav.addObject("airplanes", list);
        return mav;
    }

    @Override
    @Transactional
    public void bookTichet(String flightNo, String statusTicket, Principal principal) {
        Airplane airplane = airplaneRepository.getByFlightNo(flightNo);
        User user = userRepository.getByEmail(principal.getName());
        Flight flight = flightRepository.getByAirplane_IdAndStatusTicket(airplane.getId(), StatusTicket.valueOf(statusTicket));
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
}
