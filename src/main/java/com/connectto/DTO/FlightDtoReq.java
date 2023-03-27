package com.connectto.DTO;

import com.connectto.enums.Remarks;
import com.connectto.enums.StatusTicket;
import lombok.Data;

import java.time.LocalTime;

@Data
public class FlightDtoReq {

    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private LocalTime timeDepature;

    private LocalTime timeArrivel;

    private Remarks remarks;

    private Integer price;

    private Integer count;

    private StatusTicket statusTicket;
}
