package com.connectto.model;

import com.connectto.enums.StatusTicket;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Airplane airplane;

    @OneToMany(mappedBy = "flight" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> book;

    @Enumerated(EnumType.STRING)
    @Column(name = "Baggage_status")
    private StatusTicket statusTicket;
}
