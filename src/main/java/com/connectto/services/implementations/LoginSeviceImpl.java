package com.connectto.services.implementations;

import com.connectto.DTO.AirplaneSaveDtoReq;
import com.connectto.DTO.AirplaneInfoGetDto;
import com.connectto.DTO.TicketDto;
import com.connectto.enums.Remarks;
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
import com.connectto.util.MailSender;
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

    @Autowired
    private MailSender mailSender;


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
        Flight flight = flightRepository.getByAirplane_IdAndStatusTicket(airplane.getId(),
                StatusTicket.valueOf(statusTicket));
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
        AirplaneInfoGetDto airplane = airplaneRepository.getFlightNoUpdate(flightNo);
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
        List<User> users = userRepository.getByBookByFlightByAirplane(airplane1.getId());
        for (User user : users) {
            mailSender.tokenSimpleMessage(user.getEmail(), subject, text);
        }
    }

    @Override
    public void delete(String flightNo, String statusTicket) {
        Airplane airplane = airplaneRepository.getByFlightNo(flightNo);
        Flight flight = flightRepository.getByAirplane_IdAndStatusTicket(airplane.getId(),
                StatusTicket.valueOf(statusTicket));
        List<User> users = userRepository.getByBookByFlightByAirplane(airplane.getId());
        flightRepository.deleteById(flight.getId());
        String subject = "Airplane company";
        String text = "Delete the flight of the plane   " + airplane.toString();
        for (User user : users) {
            mailSender.tokenSimpleMessage(user.getEmail(), subject, text);
        }
    }
}
