package com.connectto.DTO;

import com.connectto.enums.Remarks;
import com.connectto.enums.StatusTicket;

import java.time.LocalTime;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public StatusTicket getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(StatusTicket statusTicket) {
        this.statusTicket = statusTicket;
    }
}
