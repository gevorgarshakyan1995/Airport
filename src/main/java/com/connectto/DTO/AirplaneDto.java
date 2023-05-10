package com.connectto.DTO;


import com.connectto.enums.Remarks;

import java.time.LocalTime;

public class AirplaneDto {

    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private LocalTime timeDepature;

    private LocalTime timeArrivel;

    private Remarks remarks;;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getCityDepartune() {
        return cityDepartune;
    }

    public void setCityDepartune(String cityDepartune) {
        this.cityDepartune = cityDepartune;
    }

    public String getCityArrival() {
        return cityArrival;
    }

    public void setCityArrival(String cityArrival) {
        this.cityArrival = cityArrival;
    }

    public LocalTime getTimeDepature() {
        return timeDepature;
    }

    public void setTimeDepature(LocalTime timeDepature) {
        this.timeDepature = timeDepature;
    }

    public LocalTime getTimeArrivel() {
        return timeArrivel;
    }

    public void setTimeArrivel(LocalTime timeArrivel) {
        this.timeArrivel = timeArrivel;
    }

    public Remarks getRemarks() {
        return remarks;
    }

    public void setRemarks(Remarks remarks) {
        this.remarks = remarks;
    }
}
