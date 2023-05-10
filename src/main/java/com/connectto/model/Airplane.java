package com.connectto.model;

import javax.persistence.*;

import com.connectto.enums.Remarks;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_No",unique = true, nullable = false)
    private String flightNo;

    @Column(name = "city_departune")
    private String cityDepartune;

    @Column(name = "city_arrival")
    private String cityArrival;

    @Column(name = "time_Depature")
    private LocalTime timeDepature;

    @Column(name = "time_Arrivel")
    private LocalTime timeArrivel;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "Remarks")
    private Remarks remarks;

    @OneToMany(mappedBy = "airplane",fetch = FetchType.LAZY)
    private List<Flight> flights;

    @Override
    public String toString() {
        return "Airplane{" +
                "flightNo='" + flightNo + '\'' +
                ", cityDepartune='" + cityDepartune + '\'' +
                ", cityArrival='" + cityArrival + '\'' +
                ", timeDepature=" + timeDepature +
                ", timeArrivel=" + timeArrivel +
                ", remarks=" + remarks +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
