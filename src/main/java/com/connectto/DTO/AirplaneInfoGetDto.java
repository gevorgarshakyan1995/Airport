package com.connectto.DTO;

import com.connectto.enums.Remarks;
import lombok.Data;

import java.time.LocalTime;

@Data
public class AirplaneInfoGetDto {

    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private LocalTime timeDepature;

    private LocalTime timeArrivel;

    private Remarks remarks;

    public AirplaneInfoGetDto(String flightNo, String cityDepartune,
                              String cityArrival, LocalTime timeDepature, LocalTime timeArrivel,
                              Remarks remarks) {
        this.flightNo = flightNo;
        this.cityDepartune = cityDepartune;
        this.cityArrival = cityArrival;
        this.timeDepature = timeDepature;
        this.timeArrivel = timeArrivel;
        this.remarks = remarks;
    }
}
