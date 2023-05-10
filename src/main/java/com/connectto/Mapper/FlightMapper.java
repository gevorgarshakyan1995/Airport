package com.connectto.Mapper;

import com.connectto.DTO.FlightInfoGetDto;
import com.connectto.DTO.FlightSaveDto;
import com.connectto.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface FlightMapper {

    @Mapping(target="remarks", source="flight.airplane.remarks")
    @Mapping(target="flightNo", source="flight.airplane.flightNo")
    @Mapping(target="cityDepartune", source="flight.airplane.cityDepartune")
    @Mapping(target="cityArrival", source="flight.airplane.cityArrival")
    @Mapping(target="timeDepature", source="flight.airplane.timeDepature")
    @Mapping(target="timeArrivel", source="flight.airplane.timeArrivel")
    FlightInfoGetDto toFlightDto (Flight flight);

    @Mapping(target="remarks", source="flight.airplane.remarks")
    @Mapping(target="flightNo", source="flight.airplane.flightNo")
    @Mapping(target="cityDepartune", source="flight.airplane.cityDepartune")
    @Mapping(target="cityArrival", source="flight.airplane.cityArrival")
    @Mapping(target="timeDepature", source="flight.airplane.timeDepature")
    @Mapping(target="timeArrivel", source="flight.airplane.timeArrivel")
    List<FlightInfoGetDto> toFlightDtos (List<Flight> flight);

    Flight toFlight(FlightSaveDto flightSaveDto);
}
