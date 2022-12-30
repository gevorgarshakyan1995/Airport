package com.connectto.DTO.Response;

import com.connectto.enums.Remarks;
import com.connectto.enums.StatusTicket;
import lombok.Data;

import java.time.LocalTime;

@Data
public class TicketDto {
    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private LocalTime timeDepature;

    private LocalTime timeArrivel;

    private Remarks remarks;

    private Integer price;

    private StatusTicket statusTicket;

    public TicketDto(String flightNo, String cityDepartune, String cityArrival, LocalTime timeDepature,
                     LocalTime timeArrivel, Remarks remarks, Integer price, StatusTicket statusTicket) {
        this.flightNo = flightNo;
        this.cityDepartune = cityDepartune;
        this.cityArrival = cityArrival;
        this.timeDepature = timeDepature;
        this.timeArrivel = timeArrivel;
        this.remarks = remarks;
        this.price = price;
        this.statusTicket = statusTicket;
    }
}

