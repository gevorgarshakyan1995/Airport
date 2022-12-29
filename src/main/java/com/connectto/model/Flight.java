package com.connectto.model;

import com.connectto.enums.StatusTicket;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    private Integer price;

    @ManyToOne
    @JoinColumn
    private Airplane airplane;

    @Enumerated(EnumType.STRING)
    @Column(name = "Baggage_status")
    private StatusTicket statusTicket;
}
