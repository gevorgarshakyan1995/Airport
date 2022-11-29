package com.connectto.DTO.Request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;


import java.time.LocalTime;

@Data
public class AirplaneSaveDtoReq {

    @NotNull
    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private LocalTime timeDepature;

    private LocalTime timeArrivel;

    private String remarks;


}
