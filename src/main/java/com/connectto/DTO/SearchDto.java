package com.connectto.DTO;


public class SearchDto {
    private String flightNo;

    private String cityDepartune;

    private String cityArrival;

    private String timeDepature;

    private String timeArrivel;

    private String remarks;

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

    public String getTimeDepature() {
        return timeDepature;
    }

    public void setTimeDepature(String timeDepature) {
        this.timeDepature = timeDepature;
    }

    public String getTimeArrivel() {
        return timeArrivel;
    }

    public void setTimeArrivel(String timeArrivel) {
        this.timeArrivel = timeArrivel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
