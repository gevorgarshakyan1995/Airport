package com.connectto.DTO;

import com.connectto.enums.Remarks;
import com.connectto.enums.StatusTicket;
import lombok.Data;

import java.time.LocalTime;

@Data
public class FlightInfoGetDto {

    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private LocalTime timeDepature;

    private LocalTime timeArrivel;

    private Remarks remarks;

    private Integer price;

    private Integer count;

    private StatusTicket statusTicket;

    public FlightInfoGetDto(String flightNo, String cityDepartune, String cityArrival,
                            LocalTime timeDepature, LocalTime timeArrivel, Remarks remarks, Integer price,
                            Integer count, StatusTicket statusTicket) {
        this.flightNo = flightNo;
        this.cityDepartune = cityDepartune;
        this.cityArrival = cityArrival;
        this.timeDepature = timeDepature;
        this.timeArrivel = timeArrivel;
        this.remarks = remarks;
        this.price = price;
        this.count = count;
        this.statusTicket = statusTicket;
    }
}
