package com.connectto.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
