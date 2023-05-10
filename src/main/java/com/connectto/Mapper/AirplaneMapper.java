package com.connectto.Mapper;

import com.connectto.DTO.AirplaneDto;
import com.connectto.model.Airplane;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AirplaneMapper {

    Airplane toAirplane (AirplaneDto airplaneDto);

    List<AirplaneDto> toAirplaneDto(List<Airplane> airplanes);

}
