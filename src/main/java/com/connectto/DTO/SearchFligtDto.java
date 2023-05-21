package com.connectto.DTO;

public class SearchFligtDto {

    private String cityDepartune;

    private String cityArrival;

    private String timeFrom;

    private String timeTo;

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

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }
}
