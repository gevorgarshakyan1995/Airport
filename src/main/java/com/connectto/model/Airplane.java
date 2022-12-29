package com.connectto.model;

import javax.persistence.*;

import com.connectto.enums.Remarks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
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

    @JsonIgnore
    @OneToMany(mappedBy = "airplane")
    private List<Flight> flights;
}
